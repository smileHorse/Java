package com.mt.security2.mapper;

import com.mt.security2.entity.Role;
import com.mt.security2.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    User loadUserByUsername(String username);
    List<Role> getUserRolesByUid(Integer id);
}
