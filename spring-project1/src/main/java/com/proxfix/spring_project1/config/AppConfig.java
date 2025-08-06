/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.proxfix.spring_project1.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.proxfix.spring_project1.entity.User;
import com.proxfix.spring_project1.services.UserService;

/**
 *
 * @author hakangul
 */
@Configuration
public class AppConfig {

    @Bean
    public UserService userService() {
        UserService userService = new UserService();
        List<User> userList = new ArrayList<>();

        userList.add(new User("Hakan"));
        userList.add(new User("Melih"));
        userList.add(new User("Yusuf"));
        userList.add(new User("Sözdar"));

        userService.setUsers(userList);
        return userService;
    }
}
