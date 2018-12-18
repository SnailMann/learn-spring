# Spring framework 演进为 Spring Boot


## 简化Spring Web MVC

这个工程是为了从原来spring framework的模式下转换为spring boot的工程，可以说是将传统spring工程升级的过程

- Spring Boot时代的简化
	1. 完全的自动化装配，不需要我们去实现接口，注解还是其他东西
	2. 条件装配
	3. 外部化配置

### 完全自动化装配

- 自动装配初始化DispatcherServlet -  DispatcherServletAutoConfiguration
- 替换@EnableWebMvc  - WebMvcAutoConfiguration
- Servlet容器：ServletWebServerFactoryAutoConfiguration


### 条件装配

- Web类型： Servlet（判断是非Web, Web, 还是Web Reactive类型）
- API依赖： Servlet、Spring Web Mvc(判断是否存在相应的jar依赖)
- Bean依赖： WebMvcConfigurationSupport（判断是否使用了EnableMvc注解，如果就不自动化装配了）


### 外部化配置
（说白了就是通过yml或其他配置文件来驱动我们的自动化装配，改变装配时一些bean的特性）

- Web MVC配置： WebMvcProperties
- 资源配置： ResourceProperties


#### 理解自动配置的顺序性

- 绝对顺序： @AutoConfigureOrder

比如说@AutoConfigureOrder(Orderd.HIGEST_PRECEDENCCE + 10)，那我肯定是第11个顺位启动，是绝对的



- 相对顺序： @AutoConfigureAfter

@AutoConfigureAfter({DispatcherServletAutoConfiguration.class}) 则代表使用了该注解的类肯定在DispatcherServletAutoConfiguration之后初始化
这个顺序是相对谁而言的，这个顺序会更为准确一些



#### 条件装配

Web类型判断：（ConditionalOnWebApplication）

- WebApplicationType

API判断（@ConditionalOnClass）

- Serlvet
- DispatcherServlet
- WebMvcConfigurer


bean判断（@ConditionalOnMissingBean,@ConditionalOnBean）

- WebMvcConfigurationSupport



### 错误处理：springboot兼容jsp

为了让springboot兼容jsp，我们需要在pom.xml中加入这几个依赖

```xml
        <!--springboot兼容jsp-->
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>jstl</artifactId>
            <version>1.0.2</version>
        </dependency>
        <dependency>
            <groupId>org.apache.tomcat.embed</groupId>
            <artifactId>tomcat-embed-jasper</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-tomcat</artifactId>
        </dependency>
```

为了让项目能找到jsp所在的路径，我们需要
```xml
    <!--springboot兼容jsp,找不到jsp路径-->
    <packaging>war</packaging>
```

最后将springboot项目打成war包，通过java -jar 执行war包就可以了（是war包，不是jar包）

```xml
java -jar springboot-mvc-0.0.1-SHAPSHOT.war
```



#### 关于springboot项目外部化配置

关于springboot项目外部化配置的内容，我们可以在autoconfigure包下找到spring-configuration-metadata.json中找到外部化配置的具体参数
当然，还有其他的包或者其他文件，一般是json文件
