package cn.itcast.springboot;

import cn.itcast.springboot.controller.HelloController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author chenjiahao
 * @date 2021/1/22 15:45
 * 引导类L：springboot应用的入口
 */
//@EnableAutoConfiguration   // 启用自动配置,全局，启动一次就好了,启动springboot应用的自动配置
//@ComponentScan  // 扫描该类所在的包以及它的子子孙孙
@SpringBootApplication  // 使用组合注解，相当于@EnableAutoConfiguration @ComponentScan  @SpringBootConfiguration
public class TestApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class,args);
    }
}
