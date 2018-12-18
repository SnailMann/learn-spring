# Spring framework 演进为 Spring Boot


## 简化Spring Web MVC

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
