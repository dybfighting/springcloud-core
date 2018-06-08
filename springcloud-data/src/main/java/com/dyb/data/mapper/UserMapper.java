package com.dyb.data.mapper;

import com.dyb.data.config.TargetDataSource;
import com.dyb.data.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

//    @TargetDataSource(name = "fincont")
    int insert(User record);

    int insertSelective(User record);
}