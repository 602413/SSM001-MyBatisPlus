package com.swjd.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.swjd.bean.User;
import com.swjd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;


    //去到登陆页面
    @RequestMapping("/toLogin")
    public String toLogin(Model model){
        User user=new User();
        model.addAttribute("user",user);
        return "login";
    }



    //实现登录功能
    @RequestMapping("/doLogin")
    public String doLogin(User user, Model model, HttpSession session){

        //调用service的方法
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("uname",user.getUname());
        queryWrapper.eq("password",user.getPassword());
        User u=userService.getOne(queryWrapper);
      /*  User u=userService.login(user);*/
        if (u!=null){
            //账号密码正确
            if (u.getFlag().equals("1")){
                //可以登录成功
                session.setAttribute("activeName",u.getUname());
                return "main";
            }else {
                //账号被冻结
                model.addAttribute("errorMsg","账号被冻结，请联系客服");
                model.addAttribute("user",user);
                return "login";
            }

        }else {
            //账号或密码不正确
            model.addAttribute("errorMsg","账号或密码不正确");
            model.addAttribute("user",user);
            return "login";
        }
    }





}
