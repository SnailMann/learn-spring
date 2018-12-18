# 演示传统的Spring Web MVC项目

## Spring Framework的XML开发模式

与demo-spring-mvc-annotation项目对比


### 基础架构：Servlet
Web Browser <-> WebSerber <-> Servlet Container <-> Database

- Servlet的特点:
	1. 几乎是面向http协议，其实可以不使用http协议
	2. 请求/响应式（request/response）
	3. 屏蔽网络通信的细节
	4. 有完整的生命周期(Servlet规范的生命周期)

- Servlet职责：
	1. 处理请求(request header ,request body)
	2. 资源管理(数据库连接，消息连接，其他)
	3. 视图渲染


### 步骤：
- 实现一个Controller（声明Bean）
- 配置Web MVC组件（包扫描（Spring MVC子容器，只扫描Controller层），RequestMappingHandlerMapping，RequestMappingHandlerAdapter，InternalResourceViewResolver）
- 部署DispatcherServlet（在web.xml配置DispatcherServlet）


### 部署DispatcherServlet

```xml
 <!--配置DispatcherServlet-->
    <servlet>
        <servlet-name>springmvc</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>/WEB-INF/app-context.xml</param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
    </servlet>
    <!--Servlet映射，所有数据都会经过DispatcherServlet-->
    <servlet-mapping>
        <servlet-name>springmvc</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>
```




### 使用嵌入式Tomcat容器:

```xml
 <build>
        <plugins>
            <plugin>
                <groupId>org.apache.tomcat.maven</groupId>
                <artifactId>tomcat7-maven-plugin</artifactId>
                <version>2.1</version>
                <executions>
                    <execution>
                        <id>tomcat-run</id>
                        <goals>
                            <goal>exec-war-only</goal>
                        </goals>
                        <phase>package</phase>
                        <configuration>
                            <!--ServletContext Path-->
                            <path>/</path>
                        </configuration>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>
```



#### Web MVC 核心组件

- HandlerMapping

映射请求到处理器(handler)加上其关联的拦截器(HandlerInterceptor)列表，其映射关系基于不同的HandlerMapping实现的一些标准细节。
其中两种HandlerMapping实现，RequestMappingHandlerMapping支持标注@RequestMapping的方法，SimpleUrlHandlerMapping维护精确的URI路径与处理器的映射
（handler处理器实际上就是Controller的方法）

- HandlerAdapter

帮助DispatcherServlet调用请求处理器（Handler），无需关注其中实际的调用细节。比如，调用注解实现的Controller需要解析其关联的注解。
HandlerAdapter的主要目的是为了屏蔽DispatcherServlet之间的诸多细节

- HandlerExceptionResolver

解析异常，可能策略是将异常处理映射到其他处理器(Handlers) 、或到某个HTML错误页面，或者其他

- ViewResolver

从处理器（Handler）返回字符类型的逻辑视图名称解析出实际的View对象，该对象将渲染后的内容输出到HTTP响应中

- LocaleResolver、LocaleContextResolver 

从客户端解析出Locale，为其实现国际化视图

- MultipartResolver 
解析多部分请求(如Web浏览器文件上传)的抽象实现


### SpringMVC 交互流程：

DispatcherServlet -> HandlerMapping -> Controller ->(用户实现，Service、Dao等) 返回数据-> view name ->
HandlerAdapter -> DispatcherServlet -> ViewResolver -> View -> Response


