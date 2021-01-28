package cn.itcast.service.controller;

import cn.itcast.service.client.UserClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.server.PathParam;

/**
 * @author chenjiahao
 * @date 2021/1/23 18:15
 */
@Controller
@RequestMapping("consumer/user")
//@DefaultProperties(defaultFallback = "fallbackMethod") // 全局异常，定义全局的熔断方法，返回值类型要一样，不需要定义参数
public class UserController {

    @Autowired
    private UserClient userClient;
    // 使用了Feign就不需要了
//    @Autowired
//    private RestTemplate restTemplate;

    // 开启负载均衡的话，就不需要 discoveryClient
    // eureka客户端，可以获取到eureka中服务的信息
//    @Autowired
//    private DiscoveryClient discoveryClient;  // 包含了拉取的所有服务信息

    @GetMapping
    @ResponseBody
//    @HystrixCommand(fallbackMethod = "queryUserByIdFallback")  // 局部异常，声明熔断的方法，返回值类型要相同
    @HystrixCommand
    public String queryUserById(@PathParam("id") String id) {
        /*
            开启负载均衡的话，就不需要这段代码
            // 根据服务名称，获取服务实例。有可能是集群，所以是service实例集合
            List<ServiceInstance> instances = discoveryClient.getInstances("service-provider");
            // 因为只有一个Service-provider。所以获取第一个实例
            ServiceInstance serviceInstance = instances.get(0);

            // 解决地址硬编码问题，方便维护
            return this.restTemplate.getForObject("http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/user/" + id, User.class);
        */

        //  使用负载均衡，通过服务名配置
//        return this.restTemplate.getForObject("http://service-provider/user/" + id, String.class);

        return this.userClient.queryUserById(id).toString();
    }

    // 服务降级，服务出现异常
//    public String fallbackMethod(){
//        return "服务正忙，请求稍后";
//    }
}
