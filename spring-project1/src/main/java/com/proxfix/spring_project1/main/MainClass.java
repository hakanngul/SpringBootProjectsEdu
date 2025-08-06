/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.proxfix.spring_project1.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.proxfix.spring_project1.config.AppConfig;
import com.proxfix.spring_project1.entity.User;
import com.proxfix.spring_project1.services.LoginService;
import com.proxfix.spring_project1.services.UserService;

/**
 *
 * @author hakangul
 */
public class MainClass {

    public static void main(String[] args) {
        System.out.println("Main Class");

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        for (User user : userService.getUsers()) {
            System.out.println(user.getFirstName());
        }

        System.out.println("Login Service");
        LoginService loginService = new LoginService();
        loginService.login();

        ((AbstractApplicationContext) context).close();
    }
}
