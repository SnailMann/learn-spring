## demo-spring-traditional-aop

我们在这里学习Spring AOP的经典实现方式（比较古董）
所以这里就不一一举例，仅仅是演示一下，可以通过ProxyFactory和ProxyFactoryBean的方式去实现Spring AOP


----
#### 经典的Spring AOP有两种实现方式

- Xml实现：ProxyFactoryBean
- 编程实现：ProxyFactory


----
#### 经典Spring AOP支持5种增强类型

- 前置增强 | MethodBeforeAdvice
- 后置增强 | AfterReturningAdvice
- 环绕增强 | MethodInterceptor
- 异常抛出增强 | ThrowsAdvice
- 引介增强 | IntroductionInterceptor


----
#### 经典Spring AOP支持6种切点类型

- 静态方法切点
- 动态方法切点
- 注解切点
- 表达式切点
- 流程切点
- 复合切点


----
#### 经典Spring AOP支持3切面类型

- 一般切面 | Advisor
- 切点切面 | PointcutAdvisor
- 引介切面 | IntroductionAdvisor






