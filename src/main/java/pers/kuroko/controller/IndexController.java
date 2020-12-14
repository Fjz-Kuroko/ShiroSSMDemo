package pers.kuroko.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pers.kuroko.entity.User;
import pers.kuroko.service.UserService;

@Controller("indexController")
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private UserService userService;
    Logger logger = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping("/doLogin")
    public String doLogin(@RequestParam("uname") String uname,
                          @RequestParam("upwd") String upwd, Model model) {
        Subject curUser = SecurityUtils.getSubject();
        if (!curUser.isAuthenticated()) {
            // 把用户名和密码封装成 UsernamePasswordToken对象
            UsernamePasswordToken token = new UsernamePasswordToken(uname, upwd);
            // rememberMe
            token.setRememberMe(true);
            try {
                // 执行登录
                // 执行了ShiroRealm中的doGetAuthenticationInfo方法
                curUser.login(token);
            }
            // 所有认证时异常的父类
            catch (AuthenticationException ae) {
                logger.info("登录失败，失败原因：[{}]", ae.getMessage());
                model.addAttribute("message", "用户名或密码错误");
                return "login";
            }
        }
        return "redirect:/index.jsp";
    }

    @RequestMapping("/doRegister")
    public String doRegister(@RequestParam("uname") String uname,
                             @RequestParam("upwd") String upwd, Model model) {
        if (userService.selectUserByUsername(uname) != null) {
            model.addAttribute("message", "用户已存在");
            return "register";
        }
        Object result = new SimpleHash("MD5", upwd, ByteSource.Util.bytes(uname), 1024);
        User user = new User(uname, result.toString(), "user");
        if (userService.addUser(user) > 0) {
            return "redirect:login";
        } else {
            model.addAttribute("message", "注册失败");
            return "register";
        }
    }

}
