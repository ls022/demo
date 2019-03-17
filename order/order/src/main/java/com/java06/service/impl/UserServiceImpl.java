package com.java06.service.impl;

import com.java06.mapper.UsersMapper;
import com.java06.pojo.Users;
import com.java06.service.UserService;
import com.java06.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersMapper usersMapper;


    @Override
    public Users doLogin(Users users) {
        users.setPassword(MD5Util.MD5(users.getPassword()));
        return usersMapper.doLogin(users);
    }
}
