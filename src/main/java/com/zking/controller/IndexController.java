package com.zking.controller;

import com.zking.model.User;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
/**
 * 页面跳转控制器
 */
public class IndexController {


    @RequestMapping("/")
    public String login(User user) {
        return "login";
    }

    @RequiresPermissions("用户管理")
    @RequestMapping("update")
    public String updateUser(){
        return "main";
    }

}
