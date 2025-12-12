package org.example.sqch11ex1.config;

import org.apache.catalina.User;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestOperations;


@Configuration
@EnableFeignClients(basePackages="org.example.sqch11ex1.proxy")
public class ProjectConfig {

    private RestOperations restTemplate;
    
    User user = restTemplate.getForObject(
            "https://api.example.com/users/{id}",
            User.class,
            id
    );

}
