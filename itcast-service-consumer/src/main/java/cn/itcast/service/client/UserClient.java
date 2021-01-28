package cn.itcast.service.client;

import cn.itcast.service.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author chenjiahao
 * @date 2021/1/28 12:10
 */
@FeignClient("service-provider")  // 声明微服务的id
public interface UserClient {

    @GetMapping("user/{id}")
    public User queryUserById(@PathVariable("id")String id);
}
