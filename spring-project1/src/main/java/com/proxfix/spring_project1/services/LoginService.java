/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.proxfix.spring_project1.services;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.proxfix.spring_project1.config.AppConfig;

/**
 *
 * @author hakangul
 */
public class LoginService {

    public void login() {
        // User listesine ihtiyacım var
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);
        for (int i = 0; i < userService.getUsers().size(); i++) {
            System.out.println(userService.getUsers().get(i).getFirstName());
        }

        ((AbstractApplicationContext) context).close();
    }
}
