# 6 渲染Web视图

## 6.1 理解视图解析

​	控制器方法没有直接产生浏览器中渲染所需的HTML。这些方法只是将一些数据填充到模型中，然后将模型传递给一个用来渲染的视图。这些方法会返回一个String类型的值，这个值就是视图的逻辑名称，不会直接应用具体的视图实现。

​	将控制器中请求处理的逻辑和视图中的渲染实现解耦是Spring MVC的一个重要特征。控制器方法和视图实现会在模型内容上达成一致，这个两者的最大关联。除此之外，两者应该保持足够的距离。

​	但是，如果控制器只通过逻辑视图名来了解视图的话，那Spring该如何确定使用哪一个视图实现来渲染模型呢？这就是Spring视图解析器的任务了。

​	我们使用过名为InternalResourceViewResolver的视图解析器。在它的配置中，为了得到视图的名字，会使用"/WEB-INF/views"前缀和".jsp"后缀，从而确定来渲染模型的JSP文件的物理位置。

​	来看一下视图解析器的基础知识和Spring提供的其他视图解析器。

​	Spring MVC 定义了一个名为ViewResolver的接口，它大致如下所示：

~~~java
public interface ViewResolver {
    View resolveViewName(String viewName, Locale locale) throw Exception;
}
~~~

​	当给resolveViewName()方法传入一个视图名和Locale对象时，它会返回一个View实例。View是另外一个接口，如下所示：

~~~java
public interface View {
    String getContentType();
    void render(Map<String, ?> model, HttpServletRequest request,
               HttpServletResponse response) throw Exception;
}
~~~

​	View接口的任务就是接受模型以及Servlet的request和response对象，并将输出结果渲染到response中。

​	一般来讲，我们并不需要关心这些接口。Spring提供了多个内置的实现，如下表所示：

| 视图解析器                     | 描述                                                         |
| ------------------------------ | ------------------------------------------------------------ |
| BeanNameViewResolver           | 将视图解析为Spring应用上下文中的bean，其中bean的id与视图的名称相同 |
| ContentNegotiatingViewResolver | 通过考虑客户端需要的内容类型来解析视图，委托给另外一个能够产生对应内容类型的视图解析器 |
| FreeMarkerViewResolver         | 将视图解析为FreeMarker模板                                   |
| InternalResourceViewResolver   | 将视图解析为Web应用的内部资源(一般为JSP)                     |
| JasperReportsViewResolver      | 将视图解析为JasperReports定义                                |
| ResourceBundleViewResolver     | 将视图解析为资源bundle(一般为属性文件)                       |
| TilesViewResolver              | 将视图解析为Apache Tile定义，其中tile id与视图名称相同。注意有两个不同的TilesViewResolver实现，分别对应于Tiles 2.0和Tiles 3.0。 |
| UrlBasedViewResolver           | 直接根据视图的名称解析视图，视图的名称会匹配一个物理视图的定义 |
| VelocityLayoutViewResolver     | 将视图解析为Velocity布局，从不同的Velocity模板中组合页面     |
| VelocityViewResolver           | 将视图解析为Velocity模板                                     |
| XmlViewResolver                | 将视图解析为特定XML文件中的bean定义，类似于BeanNameViewResolver |
| XsltViewResolver               | 将视图解析为XSLT转换后的结果                                 |

​	Spring 4和Spring 3.2 支持上表中所有的视图解析器。Spring 3.1 支持除Tiles 3 TilesViewResolver之外的所有视图解析器。

## 6.2 使用Thymeleaf

​	Thymeleaf模板是原生的，不依赖于标签库。它能在接受原始HTML的地方进行编辑和渲染。因为它没有与Servlet规范耦合，因此Thymeleaf模板能够进入JSP所无法涉足的领域。

### 6.2.1 配置Thymeleaf视图解析器

​	为了要在Spring中使用Thymeleaf，我们需要配置三个启用Thymeleaf和Spring集成的bean：

- ThymeleafViewResolver：将逻辑视图名称解析为Thymeleaf模板视图；

- SpringTemplateEngine：处理模板并渲染结果；

- TemplateResolver：加载Thymeleaf模板。

  下面为声明这些bean的Java配置：

  ~~~java
  @Bean
  // Thymeleaf视图解析器
  public ViewResolver viewResolver(ISpringTemplateEngine templateEngine) {
      ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
      viewResolver.setContentType("text/html; charset=utf-8");
      viewResolver.setTemplateEngine(templateEngine);
      return viewResolver;
  }
  
  @Bean
  // 模板引擎
  public TemplateEngine templateEngine(ITemplateResolver templateResolver) {
      SpringTemplateEngine templateEngine = new SpringTemplateEngine();
      templateEngine.setTemplateResolver(templateResolver);
      return templateEngine;
  }
  
  @Bean
  // 模板解析器
  public ITemplateResolver templateResolver() {
      WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
      AbstractConfigurableTemplateResolver templateResolver =
          new ServletContextTemplateResolver(webApplicationContext.getServletContext());
      templateResolver.setPrefix("/WEB-INF/templates");
      templateResolver.setSuffix(".html");
      templateResolver.setTemplateMode(TemplateMode.HTML);
      return templateResolver;
  }
  ~~~

  ​	ThymeleafViewResolver是Spring MVC 中ViewResolver的一个实现类。像其他的视图解析器一样，它会接受一个逻辑视图名称，并将其解析为视图。

  ​	不过需要注意的是，ThymeleafViewResolver bean中注入了一个对SpringTemplateEngine bean的引用。SpringTemplateEngine 会在Spring中启用Thymeleaf引擎，用来解析模板，并基于这些模板渲染结果。可以看到，我们为其注入了一个TemplateResolver bean的引用。

  ​	TemplateResolver 会最终定位和查找模板。与之前配置InternalResourceViewResolver类似，它使用了prefix和suffix属性。前缀和后缀将会与逻辑视图名组合使用，进而定位Thymeleaf引擎。它的templateMode属性被设置为了Html 5，这表明我们预期要解析的模板会渲染成HTML5 输出。

### 6.2.2 定义Thymeleaf模板

​	Thymeleaf没有什么特殊的标签或标签库。它之所以能发挥作用，是因为它通过自定义的命名空间，为标准的HTML标签集合添加Thymeleaf属性。

~~~html
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml"
    xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Spittr</title>
    <link rel="stylesheet" type="text/css" th:href="@{/resources/style.css}" />
</head>
<body>
    <h1>Welcome to Spittr</h1>

    <a th:href="@{/spittles}">Spittles</a>
    <a th:href="@{/spitter/register}">Register</a>
</body>
</html>
~~~

​	这个模板比较简单，只使用了th:href属性。这个属性与对应的元素HTML属性很类似，也就是href属性，并且可以按照相同的方式来使用。th:href属性的特殊之处在于它的值中可以包含Thymeleaf表达式，用来计算动态的值。它会渲染成一个标准的href属性，其中会包含在渲染时动态创建得到的值。这是Thymeleaf命名空间中很多属性的运行方式：它们对应标准的HTML属性，并且具有相同的名称，但是会渲染一些计算后得到的值。本例中，使用th:href属性的三个地方都用到了"@{}"表达式，用来计算相对于URL的路径。