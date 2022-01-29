package com.example.woc.mapper;

import com.example.woc.entity.Account;
import org.apache.ibatis.annotations.*;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.stereotype.Repository;

/**
 * @author: 風楪fy
 * @create: 2022-01-15 01:22
 **/
@Mapper
@Repository
public interface UserMapper {
//   通过id得到一个Account
    Account getById(Integer id);
//   通过username得到一个Account
    Account getByName(String username);
//  存储一位Account
    int save(Account account);
//    得到Account总数
    Integer getAmount();
//    通过用户名来删除Account
    Integer deleteAccount(String username);
}
