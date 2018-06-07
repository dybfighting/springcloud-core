package com.dyb.data.service.impl;

import com.dyb.data.config.TargetDataSource;
import com.dyb.data.entity.User;
import com.dyb.data.mapper.UserMapper;
import com.dyb.data.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author dyb
 * @version V1.0
 * @Package com.dyb.data.service.impl
 * @Description: TODO
 * @date 2018/6/7 下午2:39
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
    @Override
//    @TargetDataSource(name = "fincont")
    public int insert(User user) {
        return userMapper.insert(user);
    }
}
