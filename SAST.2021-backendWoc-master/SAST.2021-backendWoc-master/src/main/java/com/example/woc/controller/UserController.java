package com.example.woc.controller;

import com.example.woc.entity.Account;
import com.example.woc.service.AdminService;
import com.example.woc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//@RequestParam("id") Integer id,
//@RequestParam("username") String username,
//@RequestParam("password") String password,
//@RequestParam("email") String email,
//        Model model,
//        HttpSession session

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.example.woc.Util.MD5Util.code;

/**
 * @author: 風楪fy
 * @create: 2022-01-15 01:22
 **/
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private AdminService adminService;
    @RequestMapping("/toRegister")
    public String toRegister() {
        System.out.println("toRegister方法调用成功了");
        return "register";
    }
    @RequestMapping("/toLogin")
    public String toLogin(){
        System.out.println("toLogin方法调用成功了");
        return "login";
    }
    /**
     * 完成注册功能
     * 选做：对密码进行加密处理
     */
    @RequestMapping("/register.html")
    public String register(Account account, Model model) {
        System.out.println("register方法调用成功");
        Account account1 = userService.getByName(account.getUsername());
        try {
            if (account1==null) {
                account.setId(adminService.getAmount()+1);
                boolean result = userService.register(account);
                if (result) {
                    System.out.println("注册成功,请登录!");
                    model.addAttribute("message", "注册成功,请登录!");
                    return "/login";
                } else {
                    System.out.println("注册失败，请重试!");
                    model.addAttribute("message", "注册失败,请重试!");
                    return "register";
                }
            } else {
                model.addAttribute("message", "该昵称已被占用!");
                return "register";
            }
        } catch (Exception e) {
            e.getStackTrace();
            return e.getMessage();
        }
    }

    /**
     * 完成登录功能
     *
     * @param account
     * @return 是否登录成功
     */
    @RequestMapping("/login.html")
    public String login(Account account, Model model) {
        //todo
        System.out.println("login方法调用成功");
        Account account1 = userService.getByName(account.getUsername());
        if (account1!= null) {
            if (code(account.getPassword()).equals(account1.getPassword())) {
                System.out.println("登录成功");
                return "/success";
            }
            else{
                model.addAttribute("message", "登录失败，密码错误！");
                System.out.println("密码错误");
                return "/login";
            }
        } else {
            model.addAttribute("message", "登录失败，用户不存在！");
            System.out.println("登录失败了,用户不存在");
            return "/register";
        }
    }
}


