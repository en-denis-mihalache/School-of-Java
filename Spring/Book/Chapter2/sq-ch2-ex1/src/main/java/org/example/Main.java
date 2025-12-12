package org.example;

import Objects.Parrot;
import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Parrot p = context.getBean(Parrot.class);
        System.out.println(p.getName());

        Integer number =context.getBean(Integer.class);
        System.out.println(number);

        String string = context.getBean(String.class);
        System.out.println(string);
        }
    }

