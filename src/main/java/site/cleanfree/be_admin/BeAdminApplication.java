package site.cleanfree.be_admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
@RefreshScope
public class BeAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeAdminApplication.class, args);
    }

}
