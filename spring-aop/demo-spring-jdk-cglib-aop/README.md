## demo-spring-jdk-cglib-aop

关注JDK动态代理和CGLIG动态代理的区别


### 两种代理模式在Spring中的应用

根据需求和条件，Spring会自动在JDK动态代理和CGLIG动态代理之间进行切换

- 如果目标对象实现了接口，Spring默认是使用JDK的动态代理
- 如果目标对象实现了接口，Spring可以通过设置强制使用CGLIG动态代理
- 如果目标对象没有实现接口，Spring则强制使用CGLIB动态代理





### JDK动态代理和CGLIG动态代理的实现区别

JDK动态代理：

- JDK动态代理不需要第三方库支持
- JDK动态代理依赖接口，如果要代理的对象没有实现接口，是无法运用JDK动态代理的
- 原理是利用拦截器加上反射机制生成一个实现代理接口的匿名类
- JDK动态代理依赖InvocationHandler接口，以及Proxy类的newProxyInstance方法


CGLIB动态代理：

- CGLIB动态代理依赖第三方库支持
- CGLIB动态代理不依赖接口
- 原理是利用ASM开源包，在目标类的class文件加载进来时，通过修改器字节码生成其子类，即代理类是目标类的子类
- CGLIG动态代理依赖MethodInterceptor接口和Enhancer类的setSuperClass,setCallback以及create方法


### 要注解的地方

- 因为CGLIG是基于修改字节码，生成的继承于目标的子类，所以基本原理就是代理类是继承于目标类,重写方法。
所以如果目标类的是一个final类，那么对其使用CGLIG代理是会抛异常的。另外如果目标类的方法是final方法
那么该方法也是无法被代理的

- 因为JDK动态代理是基于接口而非类的，所以即使接口的实现类是final类或者说方法时final方法，
这对JDK动态代理是没有影响的

- 无论是CGLIB还是JDK动态代理，类的静态方法都是无法被代理的