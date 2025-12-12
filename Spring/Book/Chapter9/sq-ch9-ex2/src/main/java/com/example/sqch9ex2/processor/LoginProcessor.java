package com.example.sqch9ex2.processor;


import com.example.sqch9ex2.controller.LoginController;
import com.example.sqch9ex2.service.LoggedUserManagementService;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class LoginProcessor {

    private final LoggedUserManagementService  loggedUserManagementService;

    public LoginProcessor(LoggedUserManagementService loggedUserManagementService) {
        this.loggedUserManagementService = loggedUserManagementService;
    }

    private String username;
    private String password;


    public boolean login(){

        String username=this.getUsername();
        String password=this.getPassword();

        boolean loginResult = false;
        if ("admin".equals(username) && "admin".equals(password)){
            loginResult=true;
            loggedUserManagementService.setUsername(username);
        };

        return loginResult;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
