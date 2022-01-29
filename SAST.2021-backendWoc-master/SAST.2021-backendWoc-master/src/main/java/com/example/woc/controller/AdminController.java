package com.example.woc.controller;

import com.example.woc.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 風楪fy
 * @create: 2022-01-15 04:19
 **/
@Controller
@RequestMapping("/admin")
public class AdminController {

    //请仿照 User 补充 Admin 的三层架构并完成接口
    @RequestMapping("/")
    public String toDelete() {
        System.out.println("toDelete方法调用成功了");
        return "admin";
    }
    @Autowired
    private AdminService adminService;
    /**
     * 获取当前的账户总数
     * @return
     */
    @GetMapping("/getAmount")
    public Integer getAmountOfAccounts(){
        System.out.println("调用getAmountOfAccounts方法成功!");
        Integer amount=adminService.getAmount();
        System.out.println("account的总数是"+amount);
        return amount;
    }

    /**
     * 根据用户名删除账户
     * @param username
     */
    @RequestMapping("/admin.html")
    public String deleteAccount(String username){
        System.out.println("deleteAccount方法调用成功!");
        if(adminService.deleteAccount(username)==true){
            return "Delete";
        }
        else{
            return "Delete";
        }

    }
}
