package com.example.sqch9ex3.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;


@Service
@ApplicationScope

public class LoginCountService {

    private int count = 0;
    public void increment(){
        count++;
    }
    public int getCount(){
        return count;
    }
}
