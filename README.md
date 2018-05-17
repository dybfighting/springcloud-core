# springcloud-core
1.eureka 注册中心
2.rest+ribbon 负载均衡+服务消费
3.feign 服务消费
4.hystrix 断路器
5.zuul 路由网关



feign使用hystrix-dashboard需要@EnableCircuitBreaker注解
ribbon则不用

feign自带断路器hystrix，但是在低版本中需要在application.properties中添加feign.hystrix.enabled=true
开启


