# 5 构建Spring Web应用程序

## 5.1 Spring MVC起步

​	Spring将请求在调度Servlet、处理器映射(handler mapping)、控制器以及视图解析器(view resolver)之间移动。

### 5.1.1 跟踪Spring MVC的请求

​	请求从离开浏览器开始到获取响应返回，它会经历好多站，在每站都会留下一些信息同时也会带上其他信息。下图展示了请求使用Spring MVC所经历的所有站点：

​	![1560739429033](.\images\1560739429033.png)

​	在请求离开浏览器时①，会带有用户所请求内容的信息，至少会包含请求的URL。还可能有其他的信息，例如用户提交的表单信息。

​	请求旅程的第一站是Spring的DispatcherServlet。与大多数基于Java的Web框架一样，Spring MVC 所有的请求都会通过一个前端控制器(front controller) Servlet。前端控制器是常用的Web应用程序模式，在这里一个单实例的Servlet将请求委托给应用程序的其他组件来执行实际的处理。在Spring MVC 中，DispatcherServlet就是前端控制器。

​	DispatcherServlet的任务是将请求发送给Spring MVC 控制器(controller)。控制器是一个用于处理请求的Spring组件。在典型的应用程序中可能会有多个控制器，DispatcherServlet需要知道应该将请求发送给哪个控制器。所以DispatcherServlet会查询一个或多个处理器映射(handler mapping)②来确定请求的下一站在哪里。处理器映射会根据请求所携带的URL信息来进行决策。

​	一旦选择了合适的控制器，DispatcherServlet会将请求发送给选中的控制器③。到了控制器，请求会卸下其负载(用户提交的信息)并耐心等待控制器处理这些信息。实际上，设计良好的控制器本身只处理很少甚至不处理工作，而是将业务逻辑委托给一个或多个服务对象进行处理。

​	控制器在完成逻辑处理后，通常会产生一些信息，这些信息需要返回给用户并在浏览器上显示。这些信息被称为模型(model)。不过仅仅给用户返回原始的信息是不够的，这些信息需要以用户友好的方式进行格式化，一般会是HTML。所以，信息需要发送给一个视图(view)，通常会是JSP。

​	控制器所做的最后一件事就是将模型数据打包，并且标示出用于渲染输出的视图名。它接下来会将请求连同模型和视图名发送回DispatcherServlet④。

​	这样，控制器就不会与特定的视图相耦合，传递给DispatcherServlet的视图名并不直接表示某个特定的JSP。实际上，它甚至并不能确定视图就是JSP。相反，它仅仅传递一个逻辑名称，这个名称将会用来查找产生结果的真正视图。DispatcherServlet将会使用视图解析器(view resolver)⑤来将逻辑视图名匹配为一个特定的视图实现，它可能是也可能不是JSP。

​	既然DispatcherServlet已经知道由哪个视图渲染结果，那请求的任务基本上也就完成了。它的最后一站是视图的实现(可能是JSP)⑥，在这里它交付模型数据。请求的任务也就完成了。视图将使用模型数据渲染输出，这个输出会通过响应对象传递给客户端⑦。

### 5.1.2 搭建Spring MVC

#### 配置DispatcherServlet

​	DispatcherServlet是Spring MVC的核心。它要负责将请求路由到其他的组件之中。

​	按照传统的方式，像DispatcherServlet这样的Servlet会配置在web.xml文件中，这个文件会放到应用的WAR包里面。我们会使用Java将DispatcherServlet配置在Servlet容器中，而不会使用web.xml文件。

~~~java
package spittr.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpittrWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {WebConfig.class};
    }
}
~~~

​	扩展AbstractAnnotationConfigDispatcherServletInitializer的任意类都会自动地配置DispatcherServlet和Spring应用上下文，Spring的应用上下文会位于应用程序的Servlet上下文之中。

​	在Servlet3.0环境中，容器会在类路径中查找实现了javax.servlet.ServletContainerInitializer接口的类，如果能发现的话，就会用它来配置Servlet容器。Spring提供了这个接口的实现，名为SpringServletContainerInitializer，这个类反过来又会查找实现WebApplicationInitializer的类并将配置的任务交给它们来完成。Spring3.2引入了一个便利的WebApplicationInitializer基础实现，也就是AbstractAnnotationConfigDispatcherServletInitializer。因为我们的SpittrWebAppInitializer扩展了AbstractAnnotationConfigDispatcherServletInitializer，因此当部署到Servlet3.0容器中的时候，容器会自动发现它，并用它来配置Servlet上下文。

​	第一个方法getServletMappings()，它会将一个或多个路径映射到DispatcherServlet上。这里它映射的是"/"，这表示它会是应用的默认Servlet。它会处理进入应用的所有请求。

#### 两个应用上下文之间的故事

​	当DispatcherServlet启动的时候，它会创建Spring应用上下文，并加载配置文件或配置类中所声明的bean。在getServletConfigClasses()方法中，要求DispatcherServlet加载应用上下文时，使用定义在WebConfig配置类中的bean。

​	但是在Spring Web应用中，通常还会有另外一个应用上下文。另外的这个应用上下文是由ContextLoaderListener创建的。

​	我们希望DispatcherServlet加载包含Web组件的bean，如控制器、视图解析器以及处理器映射。而ContextLoaderListener要加载应用中的其他bean。这些bean通常是驱动应用后端的中间层和数据层组件。

​	实际上，AbstractAnnotationConfigDispatcherServletInitializer会同时创建DispatcherServlet和ContextLoaderListener。getServletConfigClasses()方法返回的带有@Configuration注解的类将会用来定义DispatcherServlet应用上下文中的bean。getRootConfigClasses()方法返回的带有@Configuration注解的类将会用来配置ContextLoaderListener创建的应用上上下文中的bean。

​	需要注意的是，通过AbstractAnnotationConfigDispatcherServletInitializer来配置DispatcherServlet是传统web.xml方式的替代方案。如果你愿意，可以将二者同时使用。按照这种方式配置DispatcherServlet，唯一的问题在于它只能部署到支持Servlet3.0的服务器中才能正常工作。

#### 启用Spring MVC

​	使用XML配置时，可以使用<mvc:annotation-driven>启用注解驱动的Spring MVC。创建的最简单的Spring MVC配置是一个带有@EnableWebMvc注解的类。

~~~java
@Configuration
@EnableWebMvc
public class WebConfig {
}
~~~

​	这样可以运行，但还有不少问题：

- 没有配置视图解析器。如果这样的话，Spring默认会使用BeanNameViewResolver，这个视图解析器会查找ID与视图名称匹配的bean，并且查找的bean要是View接口，它以这样的方式来解析视图。
- 没有启用组件扫描。这样的结果就是，Spring只能找到显示声明在配置类中的控制器。
- 这样配置的话，DispatcherServlet会映射为应用的默认Servlet，所以它会处理应用的所有请求，包括对静态资源的请求，如图片和样式表。

~~~java
@Configuration
@EnableWebMvc
@ComponentScan("spittr.web")
public class WebConfig extends WebMvcConfigurerAdapter {

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
~~~

​	这里添加了@ComponentScan注解，因此将会扫描spittr.web包来查找组件。我们所编写的控制器将会带有@Controller注解，这会使其成为组件扫描时的候选bean。因此，我们不需要在配置类中显示声明任何的控制器。

​	接下来，我们添加了一个ViewResolver bean，它会查找JSP文件，在查找的时候，它会在视图名称上加一个特定的前缀和后缀。

​	最后，WebConfig类还重写了configureDefaultServletHandling()方法。通过调用DefaultServletHandlerConfigurer的enable()方法，我们要求DispatcherServlet将对静态资源的请求转发到Servlet容器中默认的Servlet上，而不是使用DispatcherServlet本身来处理此类请求。

​	RootConfig的实现为：

~~~java
@Configuration
@ComponentScan(basePackages = {"spittr"},
excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)
})
public class RootConfig {
}
~~~

​	RootConfig使用了@ComponentScan注解。这样的话，我们就有很多机会用非Web组件来充实完善RootConfig。

## 5.2 编写基本的控制器

​	在Spring MVC中，控制器只是方法上添加了@RequestMapping注解的类，这个注解声明了它们所要处理的请求。假设控制器类要处理"/"的请求，并渲染应用的首页：

~~~java
@Controller
public class HomeController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "home";
    }
}
~~~

​	@Controller注解用来声明控制器，它基于@Component注解。在这里，它的目的是辅助实现组件扫描。因此组件扫描器会自动找到HomeController，并将其声明为Spring应用上下文中的一个bean。

​	@RequestMapping注解的value属性指定了这个方法所要处理的请求路径，method属性细化了它所处理的HTTP方法。home()方法返回一个String类型的“home"。这个String将会被Spring MVC 解读为要渲染的视图名称。DispatcherServlet会要求视图解析器将这个逻辑名称解析为实际的视图。

### 5.2.1 定义类级别的请求处理

​	当控制器在类级别上添加@RequestMapping注解时，这个注解会应用到控制器的所有处理方法上。处理器方法上的@RequestMapping注解会对类级别上的@RequestMapping注解的声明进行补充。

​	@RequestMapping注解的value属性能够接受一个String类型的数组，例如：

~~~java
@Controller
@RequestMapping({"/", "/homepage"})
public class HomeController {
    @RequestMapping(method = RequestMethod.GET)
    public String home() {
        return "home";
    }
}
~~~

### 5.2.2 传递模型数据到视图中

~~~java
@Controller
@RequestMapping("/spittles")
public class SpittleController {

    private SpittleRepository spittleRepository;

    @Autowired
    public SpittleController(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String spittles(Model model) {
        model.addAttribute(spittleRepository.findSpittles(Long.MAX_VALUE, 20));
        return "spittles";
    }
}
~~~

​	我们在spittles()方法中给定了一个Model作为参数。这样，spittles()方法就能将Respository中获取到的Spittle列表填充到模型中。Model实际上就是一个Map，它会传递给视图，这样数据就能渲染到客户端了。当调用addAttribute()方法并且不指定key的时候，key会根据值的对象类型推断确定。在本例中，因为它是一个List<Spittle>，因此，键会推断为spittleList。

​	如果希望显式声明模型的key的话，也可以进行指定。如果希望使用非Spring类型的话，也可以用java.util.Map来代替Model。或者使用另一种方式实现spittles()方法：

~~~java
@RequestMapping(method = RequestMethod.GET)
    public List<Spittle> spittles(Model model) {
        return model.addAttribute(spittleRepository.findSpittles(Long.MAX_VALUE, 20));
    }
~~~

​	它并没有返回视图名称，也没有显式的设定模型，这个方法返回的是Spittle列表。当处理器方法像这样返回对象或集合时，这个值会放到模型中，模型的key会根据其类型推断得出。而逻辑视图的名称将会根据请求路径推断得出。因为这个方法处理针对"/spittles"的GET请求，因此视图的名称将是"spittles"。

## 5.3 接受请求的输入

​	Spring MVC 允许以多种方式将客户端中的数据传送到控制器的处理方法中，包括：

- 查询参数 Query Parameter
- 表单参数 Form Parameter
- 路径变量 Path Variable

### 5.3.1 处理查询参数

​	这是客户端往服务器端传送数据时，最简单和最直接的方式。

​	带有查询参数的请求类似下面所示的代码：

~~~java
mockMvc.perform(get("/spittles?max=238900&count=50"))
~~~

​	SpittleControl中的处理方法为：

~~~java
@RequestMapping(method = RequestMethod.GET)
public List<Spittle> spittles(@RequestParam("max") long max,
                              @RequestParam("count") int count) {
    return spittleRepository.findSpittles(max, count);
}
~~~

​	因为这个方法要同时处理有参数和无参数的场景，所以需要修改为：

~~~java
private static final String  MAX_LONG_AS_STRING = Long.MAX_VALUE + "";

@RequestMapping(method = RequestMethod.GET)
public List<Spittle> spittles(
    @RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) long max,
    @RequestParam(value = "count", defaultValue = "20") int count) {
    return spittleRepository.findSpittles(max, count);
}
~~~

​	@RequestParam注解的defaultValue属性表示默认值。因为查询参数都是String类型的，因此defaultValue属性需要String类型的值。当绑定到方法的max参数时，它会转换为Long类型。

### 5.3.2 通过路径参数接收输入

​	这种方式适合于构建面向资源的控制器使用。对"/spittles/12345"发起GET请求要优于对"/spittle/show?spittle_id=12345"发起请求。前者能够识别出要查询的资源，而后者描述的是带有参数的一个操作，本质上是通过HTTP发起的RPC。

​	通过路径参数进行请求类似下面所示的代码：

~~~java
mockMvc.perform(get("/spittles/12345"))
~~~

​	要让这个请求通过，我们编写的@RequestMapping要包含变量部分，这部分代表了Spittle ID。Spring MVC 允许我们在@RequestMapping路径中添加占位符。占位符的名称要用大括号"{}"括起来。路径中的其他部分要与所处理的请求完全匹配，但是占位符部分可以是任意的值。

~~~java
@RequestMapping(value = "/{spittleId}", method = RequestMethod.GET)
public String spittle(@PathVariable("spittleId") long spittleId, Model model) {
    model.addAttribute(spittleRepository.findOne(spittleId));
    return "spittle";
}
~~~

​	spittle()方法的spittledId参数上添加了@PathVariable("spittleId")注解，这表明在请求路径中，不管占位符部分的值是什么都会传递到处理器方法的spittleId参数中。因为方法的参数名碰巧和占位符的名称相同，因此可以去掉@PathVariable中的value属性。

~~~java
@RequestMapping(value = "/{spittleId}", method = RequestMethod.GET)
public String spittle(@PathVariable long spittleId, Model model) {
    model.addAttribute(spittleRepository.findOne(spittleId));
    return "spittle";
}
~~~

​	如果@PathVariable中没有value属性的话，它会假设占位符的名称与方法的参数名相同。

## 5.4 处理表单

### 5.4.1 编写处理表单的控制器

​	在处理POST类型的请求时，在请求处理完成后，最好进行一下重定向，这样浏览器的刷新就不会重复提交表单了。

~~~java
@RequestMapping(value = "/register", method = RequestMethod.POST)
public String processRegistration(Spitter spitter) {
    spitterRepository.save(spitter);

    return "redirect:/spitter/" + spitter.getUserName();
}
~~~

​	processRegistration()方法接受一个Spitter对象作为参数。这个对象有firstName、lastName、userName和passWord属性，这些属性将会使用请求中同名的参数进行填充。这个方法最后就是返回一个String类型，用来指定视图。这里不仅返回了视图的名称供视图解析器查找目标视图，而且返回的值还带有重定向的格式。

​	当InternalResourceViewResolver看到视图格式中的"redirect:"前缀时，它就知道要将其解析为重定向的规则，而不是视图的名称。本例中，视图将会重定向到"/spitter/jabuer"。

​	除了"redirect:"外，InternalResourceViewResolver还能识别"forward:"前缀，此时，请求将会前往指定的路径，而不再是重定向。

​	SpitterController处理基本信息页面的请求为：

~~~java
@RequestMapping(value = "/{userName}", method = RequestMethod.GET)
public String showSpitterProfile(@PathVariable String userName, Model model) {
    Spitter spitter = spitterRepository.findByUsername(userName);
    model.addAttribute(spitter);
    return "profile";
}
~~~

### 5.4.2 校验表单

​	如果用户在提交表单的时候，userName或password文本域为空的话，那么将会导致在新建的Spitter对象中，userName或password是空的String。如果这种现象不处理的话，将会是一个安全问题。

​	有个办法就是限制这些输入域值的长度，保持它们的值在一个合适的长度范围，避免这些输入域的误用。

​	从Spring3.0开始，在Spring MVC 中提供了对Java校验API的支持。这里并不需要什么额外的配置，只要保证在类路径下包含这个Java API的实现即可，比如Hibernate Validator。

​	Java校验API定义了多个注解，这些注解可以放到属性上，从而限制这些属性的值。所有的注解都位于javax.validation.constraints包中。下面列出了这些校验注解：

| 注解         | 描述                                                         |
| ------------ | ------------------------------------------------------------ |
| @AssertFalse | 所注解的元素必须是Boolean类型，并且值为false                 |
| @AssertTrue  | 所注解的元素必须是Boolean类型，并且值为true                  |
| @DecimalMax  | 所注解的元素必须是数字，并且它的值要小于或等于给定的BigDecimalString值 |
| @DecimalMin  | 所注解的元素必须是数字，并且它的值要大于或等于给定的BigDecimalString值 |
| @Digits      | 所注解的元素必须是数字，并且它的值必须有指定的位数           |
| @Future      | 所注解的元素必须是一个将来的日期                             |
| @Max         | 所注解的元素必须是数字，并且它的值要小于或等于给定的值       |
| @Min         | 所注解的元素必须是数字，并且它的值要大于或等于给定的值       |
| @NotNull     | 所注解的元素必须不能为null                                   |
| @Null        | 所注解的元素必须为null                                       |
| @Past        | 所注解的元素必须是一个过去的日期                             |
| @Pattern     | 所注解的元素必须匹配给定的正则表达式                         |
| @Size        | 所注解的元素必须是String、集合或数组，并且它的长度要符合给定的范围 |

​	除了以上注解，Java校验API的实现可能还会提供额外的校验注解。同时，也可以定义自己的限制条件。

~~~java
public class Spitter {
    private Long id;

    @NotNull
    @Size(min = 5, max = 16)
    private String firstName;

    @NotNull
    @Size(min = 5, max = 25)
    private String lastName;

    @NotNull
    @Size(min = 2, max = 30)
    private String userName;

    @NotNull
    @Size(min = 2, max = 30)
    private String password;

    ......
}
~~~

​	Spitter的所有属性都添加了@NotNull注解，以确保它的值不为null。添加了@Size注解以限制它们的长度在最大值和最小值之间。

​	接下来要修改processRegistration()方法来应用校验功能，启用校验功能后的代码为：

~~~java
@RequestMapping(value = "/register", method = RequestMethod.POST)
public String processRegistration(@Valid Spitter spitter, Errors errors) {
    // 如果校验出现错误，则重新返回表单
    if (errors.hasErrors()) {
        return "registerForm";
    }

    spitterRepository.save(spitter);

    return "redirect:/spitter/" + spitter.getUserName();
}
~~~

​	Spitter参数添加了@Valid注解，这会告知Spring，需要确保这个对象满足校验限制。在Spitter属性上添加校验限制并不能阻止表单提交。即便用户没有填写某个域或者某个域所给定的值超出了最大长度，processRegistration()方法依然会被调用。这样，我们就需要处理校验的错误。

​	如果校验出现错误的话，那么这些错误就可以通过Errors对象进行访问，Errors参数要紧跟在带有@Valid注解的参数后面，@Valid注解所标注的就是要校验的参数。