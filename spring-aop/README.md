## demo-spring-aop

Project to learn spring aop

## 注意

- 要注意切面的表达式定义的过于宽泛，这会导致将程序中很多的连接点都拦截，包括底层的代码，有时候有些代码是final的，又没有接口，在使用CGLIB代理的时候，就会导致出错，所以切面一定不要过于宽泛，要限制

