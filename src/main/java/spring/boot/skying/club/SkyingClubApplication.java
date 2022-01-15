package spring.boot.skying.club;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"spring.boot.core","spring.boot.skying"})
public class SkyingClubApplication {

    public static void main(String[] args) {
        SpringApplication.run(SkyingClubApplication.class, args);
    }

}
