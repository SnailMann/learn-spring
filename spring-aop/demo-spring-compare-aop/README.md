## demo-spring-compare-aop

这里主要用于比较Filter,Interceptor,Spring AOP

----
### 实现方式

Filter的实现方式：

- 自定义Filter，实现javax.servlet.Filter接口
- 通过@Component或@Bean(FilterRegistrationBean)的方式声明Filter


Interceptor的实现方式：

- 自定义拦截器，实现HandlerInterceptor接口
- 拦截器不需要@Componet修饰，而是通过一个配置类，去实现WebMvcConfigurer，重写addInterceptors方法

@Aspect方式的Spring AOP的实现方式：

- 添加AOP依赖
- 定义切面,用@Aspect注解声明这是一个切面，定义切点和增强即可
- 同时还需要模式注解@Component来修饰切面，把切面注入Spring容器中


----
### Spring Boot怎么保证多个Filter的执行顺序
当存在多个Filter时，可以通过让Filter实现Ordered类或者使用@Order注解来保证执行顺序。
当然还有些其他的方式


----
### Spring Boot怎么保证多个Interceptor的执行顺序

拦截器的执行顺序跟Filter不同，通过@Order或Ordered的方式是不同实现的。不过拦截器的顺序实现也很简单
```java
  /**
     * 这里的添加顺序就是拦截器的执行执行顺序
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
            registry.addInterceptor(new HelloInterceptor()).addPathPatterns("/**");
            registry.addInterceptor(new HelloInterceptor2()).addPathPatterns("/**");
    }
    
```
实现WebMvcConfigurer的addInterceptors方法时，添加顺序就是拦截器的执行顺序

----
### Spring Boot怎么保证多个aspect的执行顺序

@Aspect的Spring AOP方式，如果存在多个切面时，实现顺序执行的方式跟Filter差不多。都可以通过Ordered接口或@Order注解的方式实现