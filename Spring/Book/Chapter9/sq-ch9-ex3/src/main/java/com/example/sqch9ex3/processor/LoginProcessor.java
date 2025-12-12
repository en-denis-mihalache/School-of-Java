package com.example.sqch9ex3.processor;


import com.example.sqch9ex3.service.LoggedUserManagementService;
import com.example.sqch9ex3.service.LoginCountService;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class LoginProcessor {

    private final LoggedUserManagementService  loggedUserManagementService;
    private final LoginCountService loginCountService;

    public LoginProcessor(LoggedUserManagementService loggedUserManagementService,
                          LoginCountService loginCountService) {
        this.loggedUserManagementService = loggedUserManagementService;
        this.loginCountService = loginCountService;
    }

    private String username;
    private String password;


    public boolean login(){

        loginCountService.increment();

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
