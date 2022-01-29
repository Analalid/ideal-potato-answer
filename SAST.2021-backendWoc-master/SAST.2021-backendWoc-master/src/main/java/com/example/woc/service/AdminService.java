package com.example.woc.service;

import com.example.woc.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private UserMapper userMapper;

    public Integer getAmount() {
        return userMapper.getAmount();
    }

    public boolean deleteAccount(String username) {
        userMapper.deleteAccount(username);
        if (userMapper.getByName(username) == null) {
            System.out.println("删除用户" + username + "成功!");
            return true;
        } else {
            System.out.println("删除用户" + username + "失败!");
            return false;
        }
    }
}
