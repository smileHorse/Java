# 1 Spring之旅

## 1.1 简化Java开发

​	虽然Spring用bean或JavaBean来表示应用组件，但并不意味着Spring组件必须要遵循JavaBean规范。一个Spring组件可以是任何形式的POJO(Plain Old Java Object，简单老式Java对象)。

​	支撑Spring的仅仅是少许的基本理念，所有理念都可以追溯到Spring最根本的使命上：**简化Java开发**。

​	为了降低Java开发的复杂性，Spring采取了以下4种关键策略：

- 基于POJO的轻量级和最小侵入性编程；
- 通过依赖注入(dependency injection, DI)和面向接口实现松耦合；
- 基于切面(aspect-oriented programming, AOP)和惯例进行声明式编程；
- 通过切面和模板减少样板式代码。

### 1.1.1 激发POJO的潜能

​	Spring不会强迫你实现Spring规范的接口或继承Spring规范的类。在基于Spring构建的应用中，它的类通常没有任何痕迹表明你使用了Spring。最坏的场景是，一个类或许会使用Spring注解，但它仍旧是POJO。

​	Spring赋予POJO魔力的方式之一就是通过DI来装配它们。

### 1.1.2 依赖注入

​	在项目中应用DI，会发现你的代码变得异常简单并且更容易理解和测试。

​	传统的做法中，每个对象负责管理与自己相互协作的对象的引用，这将会导致高度耦合和难以测试的代码。通过DI，对象的依赖关系将由系统中负责协调各对象的第三方组件在创建对象的时候进行设定。对象无需自行创建或者管理它们的依赖关系，依赖关系将被自动注入到需要它们的对象中去。

​	构造器注入是依赖注入的方式之一。

​	创建应用组件之间协作的行为通常称为装配(wiring)。Spring有多种装配bean的方式，采用XML是很常见的一种装配方式。也支持使用Java来描述配置。

​	Spring通过应用上下文(Application context)装载bean的定义并把它们组装起来。Spring应用上下文全权负责对象的创建和组装。Spring自带了多种应用上下文的实现，它们之间主要的区别仅仅在于如何加载配置。

### 1.1.3 应用切面

​	DI能够让相互协作的软件组件保持松散耦合，而面向切面编程(AOP)允许你把遍布应用各处的功能分离出来形成可重用的组件。

​	面向切面编程往往被定义为促使软件系统实现关注点分离的一项技术。系统由许多不同的组件组成，每一个组件负责一块特定的功能。除了实现自身核心的功能以外，这些组件还经常承担着额外的职责。诸如日志、事务管理和安全这样的系统服务经常融入到自身具有核心业务逻辑的组件中去，这些系统服务通常被称为横向关注点，因为它们会跨越系统的多个组件。

​	AOP能够使这些服务模块化，并以声明的方式将它们应用到它们需要影响的组件中去。所造成的结果就是这些组件会具有更高的内聚性并且会更加关注自身的业务，完全不需要了解涉及系统服务所带来的的复杂性。总之，AOP能够确保POJO的简单性。

​	我们可以把切面想象为覆盖在很多组件之上的一个外壳。应用是由那些实现各自业务功能的模块组成的。借助AOP，可以使用各种功能层去包裹核心业务层。这些层以声明的方式灵活地应用到系统中，你的核心应用甚至根本不知道它们的存在。

### 1.1.4 使用模板消除样板式代码

​	Spring旨在通过模板封装来消除样板式代码。

## 1.2 容纳你的Bean

​	在基于Spring的应用中，应用对象生存与Spring容器中。Spring容器负责创建对象、装配它们、配置它们并管理它们的整个生命周期。

​	容器是Spring框架的核心。Spring容器使用DI管理构成应用的组件，它会创建相互协作的组件之间的关联。

​	Spring容器并不是只有一个。Spring自带多种容器实现，可以归纳为两种不同的类型：

- Bean工厂(由org.springframework.beans.factory.beanFactory接口定义)是最简单的容器，提供基本的DI支持。
- 应用上下文(由org.springframework.context.ApplicationContext接口定义)基于BeanFactory构建，并提供应用框架级别的服务，例如从属性文件解析文本信息以及发布应用事件给感兴趣的事件监听者。

   bean工厂对于大多数应用来说太过低级，因此，应用上下文要比bean工厂更受欢迎。

### 1.2.1 使用应用上下文

​	Spring自带多种类型的应用上下文，下面罗列几个可能遇到的：

- AnnotationConfigApplicationContext:从一个或多个基于Java的配置类中加载Spring应用上下文。

- AnnotationConfigWebApplicationContext:从一个或多个基于Java的配置类中加载Spring Web应用上下文。

- ClassPathXmlApplicationContext:从类路径下的一个或多个Xml配置文件中加载上下文定义，把应用上下文的定义文件作为类资源。

- FileSystemXmlApplicationContext:从文件系统下的一个或多个Xml配置文件中加载上下文定义。

- XmlWebApplicationContext:从Web应用下的一个或多个Xml配置文件中加载上下文定义。

  应用上下文准备就绪之后，就可以调用上下文的getBean()方法从Spring容器中获取bean。

### 1.2.2 bean的生命周期

​	在传统的Java应用中，bean的生命周期很简单。使用Java关键字new进行bean实例化，然后bean就可以使用了。一旦bean不再被使用，则由Java自动进行垃圾回收。

​	bean装载到Spring应用上下文中的一个典型生命周期过程，如下图所示：

![1560479186331](.\images\1560479186331.png)

1. Spring对bean进行实例化；
2. Spring将值和bean的引用注入到bean对应的属性中；
3. 如果bean实现了BeanNameAware接口，Spring将bean的ID传递给setBeanName()方法；
4. 如果bean实现了BeanFactoryAware接口，Spring将调用setBeanFactory()方法，将BeanFactory容器实例传入；
5. 如果bean实现了ApplicationContextAware接口，Spring将调用setApplicationContext()方法，将bean所在的应用上下文的引用传入进来；
6. 如果bean实现了BeanPostProcessor接口，Spring将调用它们的postProcessBeforeInitialization()方法；
7. 如果bean实现了InitializingBean接口，Spring将调用它们的afterPropertiesSet()方法。类似的，如果bean使用init-method声明了初始化方法，该方法也会被调用；
8. 如果bean实现了BeanPostProcessor接口，Spring将调用它们的postProcessAfterInitialization()方法；
9. 此时bean已准备就绪，可以被应用程序使用了，它们将一直驻留在应用上下文中，直到该应用上下文被销毁；
10. 如果bean实现了DisposableBean接口，Spring将调用它们的destroy()方法。同样，如果bean使用destroy-method声明了销毁方法，该方法也会被调用；