# 演示传统的Spring Web MVC项目

## 全注解驱动Spring framework 项目

- 与demo-spring-mvc-annotation-withweb和demo-spring-mvc-xml形成对比
- 相比demo-spring-mvc-annotation-withweb，去除掉web.xml配置，实现全注解驱动
- 全注解驱动需要依赖Spring的自动装配功能


### Spring MVC自动装配

基本要求：
- Servlet依赖：Servlet 3.0 +
- Servlet API: Servlet SontainerInitializer
- Spring适配：SpringServletContainerInitializer


Spring SPI(实现手段) : 
- 基础接口：WebApplicationInitializer

通过基础接口实现的话，所有事情都需要自己操盘，就比较复杂

- 编程(接口，抽象类)驱动：AbstractDispatcherServletInitializer

基于编程驱动

- 注解驱动：AbstractAnnotationConfigDispatcherServletInitializer

基于注解驱动，推荐这种



总结：

- 所以我们可以知道，其实不需要到SpringBoot的出现，Spring framework也可以实现组件的自动装配
替换掉大部分的xml配置
- 但是相对于SpringBoot的完全自动化装配还是麻烦一些的，毕竟在SpringBoot中，我们完全不需要自己通过接口或注解
去实现，真的是开箱即用
- 虽然spring framework也能做到嵌入式Servlet容器，但是还是存在配置问题，但是SpringBoot也不需要我们考虑这些问题，仅仅是是否导入容器依赖的问题