package config;

import model.Parrot;
import model.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    Person person(Parrot parrot) {
        Person person=new Person();
        person.setName("Alina");
        person.setParrot(parrot);
        return person;
    }

    @Bean
    Parrot parrot(){
        Parrot parrot=new Parrot();
        parrot.setName("Miku");
        return parrot;
    }
}
