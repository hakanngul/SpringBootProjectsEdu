package com.proxfix.spring_project1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
    "com.proxfix.spring_project1",
    "com.hakangul"
})
public class SpringProject1Application {
  public static void main(String[] args) {
    SpringApplication.run(SpringProject1Application.class, args);
  }
}