package com.bitsco.vks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Objects;

@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
@EntityScan(basePackages = "com.bitsco.vks.entity")
@EnableJpaRepositories(basePackages = "com.bitsco.vks.repository")
public class VksApplication {
    public static void main(String[] args) {
        Environment env = SpringApplication.run(VksApplication.class, args).getEnvironment();
        String appName = Objects.requireNonNull(env.getProperty("spring.application.name")).toUpperCase();
        String port = env.getProperty("server.port");
        System.out.println("-------------------------START " + appName + " Application------------------------------");
        System.out.println("   Application         : " + appName);
        System.out.println("   Url swagger-ui      : http://localhost:" + port + "/swagger-ui.html");
        System.out.println("-------------------------START SUCCESS " + appName + " Application------------------------------");
    }

}
