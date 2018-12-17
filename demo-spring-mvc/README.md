# 演示传统的Spring Web MVC项目




### 步骤：
1. 实现一个Controller（声明Bean）
2. 配置Web MVC组件（包扫描（Spring MVC子容器，只扫描Controller层），RequestMappingHandlerMapping，RequestMappingHandlerAdapter，InternalResourceViewResolver）
3. 部署DispatcherServlet（在web.xml配置DispatcherServlet）


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


