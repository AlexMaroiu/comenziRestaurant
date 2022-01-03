package com.ComenziRestaurant.demo.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder())
                .usersByUsernameQuery("select username, password, enabled" + " from Users" + " where username=?")
                .authoritiesByUsernameQuery("select username, authority"+ " from Authorities" + " where username=?");

//        auth.inMemoryAuthentication()
//                .withUser("alex").password(passwordEncoder().encode("pass")).roles("USER")
//                .and()
//                .withUser("Alexandru").password(passwordEncoder().encode("parola")).roles("ADMIN", "USER");
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                csrf().disable()
                .authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/inregistrare", "/submitInregistrare").permitAll()
                .antMatchers("/logare/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/logare").permitAll().defaultSuccessUrl("/");

    }
}
