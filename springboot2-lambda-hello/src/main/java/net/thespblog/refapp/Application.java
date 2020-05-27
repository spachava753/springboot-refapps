package net.thespblog.refapp;

import net.thespblog.refapp.controller.UserController;
import net.thespblog.refapp.model.User;
import net.thespblog.refapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import net.thespblog.refapp.controller.PingController;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication
@EnableWebMvc
// We use direct @Import instead of @ComponentScan to speed up cold starts
// @ComponentScan(basePackages = "net.thespblog.refapp.controller")
@Import({PingController.class, UserController.class})
// @EntityScan({ "net.thespblog.refapp.model" })
@Component
public class Application implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        User alice = new User();
        alice.setAge(22);
        alice.setFirstName("Alice");
        alice.setLastName("Doe");
        userRepository.save(alice);

        User bob = new User();
        bob.setAge(24);
        bob.setFirstName("Bob");
        bob.setLastName("Doe");
        userRepository.save(bob);

        User john = new User();
        john.setAge(44);
        john.setFirstName("John");
        john.setLastName("Wick");
        userRepository.save(john);
    }
}