# springall
springboot+springcloud分布式

服务注册服务- Eureka Server 

服务提供者provider-one和provider-two

服务消费者 - Ribbon | Feign
ribbon 实现了负载均衡，策略默认为轮询
Feign 实现服务熔断降级，当服务不可用时会执行熔断实现类
