package org.example;

import config.AppConfig;
import model.Parrot;
import model.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.ObjectInputFilter;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        var context = new AnnotationConfigApplicationContext(AppConfig.class);

        Person person = context.getBean(Person.class);
        Parrot parrot = context.getBean(Parrot.class);

        System.out.println(person.getName()+" "+ person.getParrot());
    }
}
