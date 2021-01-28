package cn.itcast.service;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

//@SpringBootApplication
//@EnableDiscoveryClient  // 开启eureka
//@EnableCircuitBreaker  // 开启熔断
@SpringCloudApplication  // 组合注解，相当于上面三个注解
@EnableFeignClients // 启用Feign组件
public class ItcastServiceConsumerApplication {

    // 使用Feign就不需要下面这个
    // 在引导类中注册 RestTemplate
    /*
    @Bean
    @LoadBalanced  // 开启负载均衡
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    */
    public static void main(String[] args) {
        SpringApplication.run(ItcastServiceConsumerApplication.class, args);
    }


}
