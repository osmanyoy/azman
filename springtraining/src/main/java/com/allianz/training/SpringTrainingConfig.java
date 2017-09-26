package com.allianz.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
public class SpringTrainingConfig {

    @Autowired
    public void configAuthantication(AuthenticationManagerBuilder managerBuilder,
            CustomUserDetails cud) throws Exception {
        // managerBuilder.inMemoryAuthentication()
        // .withUser("osman")
        // .password("98765")
        // .roles("USER",
        // "ADMIN")
        // .and()
        // .withUser("ali")
        // .password("1234")
        // .roles("USER");

        managerBuilder.userDetailsService(cud);
    }

}
