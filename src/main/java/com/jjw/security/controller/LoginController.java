package com.jjw.security.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @author jijiawei
 * @Description TODO
 * @date 2020/11/16 12:00
 */
@Controller
@Slf4j
public class LoginController {
    /**
     * 获取当前用户
     * @return
     */
    @RequestMapping("/")
    public String showHome() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        log.info("当前登陆用户：" + name);

        return "home.html";
    }

    @RequestMapping("/login")
    public String showLogin() {
        return "login.html";
    }

    @RequestMapping("/admin")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String printAdmin() {
        return "如果你看见这句话，说明你有ROLE_ADMIN角色";
    }

    @RequestMapping("/checker")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_收银员')")
    public String printChecker() {
        return "如果你看见这句话，说明你有ROLE_收银员角色";
    }

    @RequestMapping("/manager")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_店长')")
    public String printManager() {
        return "如果你看见这句话，说明你有ROLE_店长角色";
    }

    @RequestMapping("/login/error")
    public void loginError(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        AuthenticationException exception =
                (AuthenticationException)request.getSession().getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
        try {
            response.getWriter().write(exception.toString());
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}