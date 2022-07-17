package pl.technique.stage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class StageTechniqueApplication {

    public static void main(String[] args) {
        SpringApplication.run(StageTechniqueApplication.class, args);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoderBean() {
        return new BCryptPasswordEncoder();
    }
}
