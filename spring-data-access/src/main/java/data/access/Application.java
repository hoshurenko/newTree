package data.access;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;

@SpringBootApplication
public class Application {

    @Autowired
    private static EntityManager entityManager1;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
