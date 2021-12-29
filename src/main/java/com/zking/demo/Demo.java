package com.zking.demo;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;

public class Demo {

    public static void main(String[] args) {
        //1.读取加载shiro.ini配置文件
        IniSecurityManagerFactory iniSecurityManagerFactory = new IniSecurityManagerFactory("classpath:shiro-permission.ini");
        //2.创建SecurityManager安全管理器
        SecurityManager securityManager = iniSecurityManagerFactory.getInstance();
        //3.将SecurityManager委托给SecurityUtils管理
        SecurityUtils.setSecurityManager(securityManager);
        //4.获取主体
        Subject subject = SecurityUtils.getSubject();
        //5.创建token令牌（基于账号密码登陆）
        UsernamePasswordToken  token = new UsernamePasswordToken(
                "ls","123"
        );
        try {
            //6.身份验证
            subject.login(token);
            if(subject.isPermitted("user:create")){
                System.out.println("创建");
            }
            if(subject.isPermitted("user:update")){
                System.out.println("更新");
            }
            if(subject.isPermitted("user:delete")){
                System.out.println("删除");
            }
            if(subject.isPermitted("user:view")){
                System.out.println("查询");
            }
            if(subject.isPermitted("user:load")){
                System.out.println("加载");
            }
        } catch (UnknownAccountException e) {
            System.out.println("用户名不存在！");
        }catch (IncorrectCredentialsException e){
            System.out.println("密码错误！");
        }finally {
            subject.logout();
            System.out.println("退出登录！");
        }
    }

}
