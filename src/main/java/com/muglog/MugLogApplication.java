package com.muglog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EnableAspectJAutoProxy /* AOP */
public class MugLogApplication {

    public static void main(String[] args) {
        SpringApplication.run(MugLogApplication.class, args);
    }

}
