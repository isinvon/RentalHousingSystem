package com.sinvon.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sinvon.server.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
