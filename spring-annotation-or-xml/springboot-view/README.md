# Spring MVC 模板引擎


### 模板引擎的核心要素

- 资源定位：模板来源
	1. 通用资源抽象：
		1. 文件资源：File
		2. ClassPath资源：ClassLoader
		3. 统一资源：URL
		4. Web资源：ServletContext
	2. Spring资源抽象：
		1. Spring资源：Resource

		
- 渲染上下文：变量来源
    1. 不同实现：
		1. Context : Thymeaf 渲染上下文
		2. Model : Spring Web MVC模型
		3. Attribute : Servlet 上下文

- 模板引擎：模板渲染
	1. ITemplateEngine : 
		1. Thymeleaf原生实现
		2. SpringTemplateEngine：Spring实现
		3.  SpringWebFluxTemplateEngine：Spring WebFlux实现




## Spring Web MVC视图组件

- 视图解析器：ViewResolver  - 资源定位的工具
- 视图： View - 模板渲染的实现
- 总控： DispatcherServlet - 前端控制器


### JSP 整合 Spring Web MVC

- 视图解析器： InternalResourceViewResolver
- 视图：JstlView

我们在demo-spring-mvc-xml工程中还记得需要配置视图解析器和viewClass吗？就是以上的这两个东西

### Thymeleaf 整合 Spring Web MVC

- 视图解析器： ThymeleafViewResolver
- 视图：ThymeleafView
- 渲染：SpringTemplateEngine


如果一个Spring项目中，存在多个视图解析器，比如jsp和thymeleaf共存的时候，就会有jsp的解析器InternalResourceViewResolver
和thymeleaf的解析器ThymeleafViewResolver。这时候DispatcherServlet中处理多个解析器，根据优先级进行遍历


### 多视图处理器并存

- 视图处理器:
    1. ThymeleafViewResolver
    2. InternalResourceViewResolver
- 目的：
    1. 理解ViewResovler,Order
    2. 理解ViewResolver模板资源查找
    3. 自定义ViewResolver,Order
    
#### 实现共存的步骤：

1. 添加jsp依赖包
2. 修改pom.xml中packageing为war包，而不是jar包    
3. 因为InternalResourceViewResolver的加载顺序不如ThymeleafViewResolver，所以我们要自定义InternalResourceViewResolver，升级其顺序
    