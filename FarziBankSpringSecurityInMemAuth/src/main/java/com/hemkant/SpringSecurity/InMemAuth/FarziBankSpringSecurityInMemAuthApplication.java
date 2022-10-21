package com.hemkant.SpringSecurity.InMemAuth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
/** REmoving them as we have all the package under the main package "com.hemkant.SpringSecurity.InMemAuth"
 * if you can direct package then we should include them.
@EnableJpaRepositories("com.hemkant.SpringSecurity.InMemAuth.Repository")
@EntityScan("com.hemkant.SpringSecurity.InMemAuth.Model")*/
public class FarziBankSpringSecurityInMemAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(FarziBankSpringSecurityInMemAuthApplication.class, args);
	}

}
