package cn.itcast.service.service;

import cn.itcast.service.mapper.UserMapper;
import cn.itcast.service.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chenjiahao
 * @date 2021/1/23 14:48
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User queryUserById(String id){
        return this.userMapper.selectByPrimaryKey(id);
    }

}
