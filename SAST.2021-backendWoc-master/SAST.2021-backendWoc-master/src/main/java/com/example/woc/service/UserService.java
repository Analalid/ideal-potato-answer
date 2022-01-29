package com.example.woc.service;

import com.example.woc.entity.Account;
import com.example.woc.mapper.UserMapper;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static com.example.woc.Util.MD5Util.code;


/**
 * @author: 風楪fy
 * @create: 2022-01-15 01:22
 **/
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;
    public Account getById(Integer id){
        return userMapper.getById(id);
    }
    public Account getByName(String username){
        return userMapper.getByName(username);
    }
    public boolean register(Account account){
        account.setPassword(code(account.getPassword()));
        return userMapper.save(account)>0;
    }


}
