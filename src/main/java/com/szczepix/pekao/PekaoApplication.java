package com.szczepix.pekao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import pl.pekao24.api.Credentials;

@SpringBootApplication(scanBasePackages={"pl.pekao24.api", "com.szczepix.pekao"})
@EnableConfigurationProperties(Credentials.class)
public class PekaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PekaoApplication.class, args);
    }

}
