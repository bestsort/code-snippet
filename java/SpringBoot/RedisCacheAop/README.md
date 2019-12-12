## 用途
主要用于 Spring Boot 使用面向切面编程的形式整合Redis缓存，由于Spring Boot自带的Redis Manager功能有限（比如不支持随机TTL，不支持自增等），因此采用自定义`@Cache`注解达到预期效果
## 依赖
- Spring Boot AOP
- LomBok
- Jedis
- Fastjson

## 注意事项
1. 本写法只是示例，里面写了很多**有状态Bean**。因为`@Service`默认是单例模式，所以在高并发下需要注意**线程安全问题**。
2. AOP只能在方法之间切入，内部调用无法使用AOP。