# springcloud-core
feign使用hystrix-dashboard需要@EnableCircuitBreaker注解
ribbon则不用

feign自带断路器hystrix，但是在低版本中需要在application.properties中添加feign.hystrix.enabled=true
开启


