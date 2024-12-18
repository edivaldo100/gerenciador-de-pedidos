package org.eduami.spring.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RestapiApplication  implements CommandLineRunner {
    @Autowired
    private RunApp app;
    public static void main(String[] args) {
        SpringApplication.run(RestapiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("---------------------------------------------------->>>>>>>>>>");
        System.out.println("-----------------------START APP--------------------->>>>>>>>>");
        System.out.println("---------------------------------------------------->>>>>>>>>>");

        app.appStart();

    }
}
