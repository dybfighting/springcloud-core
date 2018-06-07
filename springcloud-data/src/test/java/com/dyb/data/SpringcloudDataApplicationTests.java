package com.dyb.data;

import com.dyb.data.entity.User;
import com.dyb.data.mapper.UserMapper;
import com.dyb.data.proxy.UserServiceProxy;
import com.dyb.data.service.UserService;
import com.dyb.data.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringcloudDataApplicationTests {

	@Autowired
	UserMapper userMapper;
	@Autowired
	UserService userService;
	@Autowired
	UserServiceProxy userServiceProxy;
	@Test
	public void contextLoads() {
		User user = new User();
		user.setAge(192222);
		user.setName("能吃吗最出色的");
		userMapper.insert(user);
	}
	@Test
	public void testService(){



		userService = (UserService) userServiceProxy.bind(userService);
		User user = new User();
		user.setAge(00000);
		user.setName("zzz111111");
		userService.insert(user);
	}

}
