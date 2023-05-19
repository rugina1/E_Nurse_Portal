package com.e_nursing_portal.securityconfig;

import com.e_nursing_portal.service.UserInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    private final CustomAuthenticationSuccessHandler authenticationSuccessHandler;


    private final UserInterface userInterface;

    public SecurityConfiguration(UserInterface userInterface,CustomAuthenticationSuccessHandler authenticationSuccessHandler) {
        this.userInterface = userInterface;
        this.authenticationSuccessHandler = authenticationSuccessHandler;
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
         DaoAuthenticationProvider auth=new DaoAuthenticationProvider();
         auth.setUserDetailsService(userInterface);
         auth.setPasswordEncoder(bCryptPasswordEncoder());
         return auth;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)throws Exception{
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
      http.authorizeRequests().antMatchers(
                  "/registration**",
                    "/js/**",
                    "/css/**",
                    "/img/**").permitAll()
              .antMatchers("/login").permitAll()
              .antMatchers("/admin/**").hasRole("ADMIN")
              .anyRequest().authenticated()
              .and()
              .formLogin()
              .loginPage("/login")
              .usernameParameter("email")
              .passwordParameter("password")
              .successHandler(authenticationSuccessHandler)
              .and()
              .sessionManagement() // add session management
              .sessionFixation().migrateSession() // enable session fixation protection and migrate sessions
              .maximumSessions(1) // allow only one session per user
              .expiredUrl("/login?expired") // redirect to this URL if session is expired
              .and()
              .invalidSessionUrl("/login?invalid") // redirect to
              .and()
              .logout()
              .invalidateHttpSession(true)
              .clearAuthentication(true)
              .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
              .logoutSuccessUrl("/login?logout")
              .permitAll();

    }
}
