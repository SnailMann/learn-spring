# 演示传统的Spring Web MVC项目

## Spring Web 注解驱动


### 开发版本依赖

- Spring Framework 3.1 +(要实现Web MVC注解驱动，Spring Framework至少是3.1或以上)

### 注解开发基本配置
- 注解配置：@Configuration (Spring 范式注解，模式注解)
- 组件激活： @EnableWebMvc(Spring 模块装配，替代配置文件)
- 自定义组件： WebMvcConfigurer(Spring Bean)




### 自定义组件： WebMvcConfigurer(Spring Bean)

注解配置和组件激活比较简单，就不说了，自定义组件的话，我们可以通过实现WebMvcConfigurer接口去完成。
也许，你还会想到一个叫WebMvcConfigurerAdapter的抽象类，不过这个抽象类在Spring 5+ 之后就被淘汰了。因为之后的WebMvcConfigurer使用Java 8 语法实现，
接口可以有默认方法，然后再看看他们两者的代码，就会发现使用了java 1.8语法的WebMvcConfigurer和WebMvcConfigurerAdapter几乎一模一样，所以WebConfigurerAdapter就没有任何意义了。







