package com.scm.config;

import java.io.IOException;

// import java.beans.Customizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.scm.services.impl.SecurityCustomUserDetailService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Configuration
public class SecurityConfig {

    // private UserDetailsService inMemoryDetailsManager;
    
    // user create and login using java code with in memory service

    // @Bean
    // public UserDetailsService userDetailsService(){

    //    UserDetails user1= User
    //         .withDefaultPasswordEncoder()
    //         .username("admin123")
    //         .password("admin@123")
    //         .roles("ADMIN","USER")
    //         .build(); 

    //     UserDetails user2= User
    //     .withDefaultPasswordEncoder()
    //         .username("user123")
    //         .password("user@123")
    //         .build();

    //     var inMemoryUserDetailsManager= new InMemoryUserDetailsManager(user1, user2);
    //     return inMemoryUserDetailsManager;
    // }
    
    @Autowired
    private SecurityCustomUserDetailService userDetailService;

    @Autowired
    private OAuthAuthenticationSuccessHandler handler;

    @Autowired
    private AuthFailureHandler authFailureHandler;

    // configuration of authentication provider
    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        // user detail service ka object
        daoAuthenticationProvider.setUserDetailsService(userDetailService);
        // password encoder ka object
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        
        return daoAuthenticationProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{

        // configuration 

        // url configure kiya hai konse public rahenge and konse private
        httpSecurity.authorizeHttpRequests(authorize->{
            // authorize.requestMatchers("/home", "/register","/services").permitAll();
            authorize.requestMatchers("/user/**").authenticated();
            authorize.anyRequest().permitAll();
        });

        // form default login
        // agar hame kuchbhi chnge karna hoga form login se related hum yaha karenge
        httpSecurity.formLogin(formLogin->{

            // 
            formLogin.loginPage("/login");
            formLogin.loginProcessingUrl("/authenticate");
            formLogin.successForwardUrl("/user/profile");
            // formLogin.failureForwardUrl("/login?error=true");
            // formLogin.defaultSuccessUrl("/home");
            formLogin.usernameParameter("email");
            formLogin.passwordParameter("password");

            // formLogin.failureHandler(new AuthenticationFailureHandler() {
            //     @Override
            //     public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
            //         throw new UnsupportedOperationException("Not supported yet.");
            //     }
                
            // });
            // formLogin.successHandler(new AuthenticationSuccessHandler() {
            //     @Override
            //     public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
            //         throw new UnsupportedOperationException("Not supported yet.");
            //     }
            // });

            formLogin.failureHandler(authFailureHandler);
            
            
        });
        httpSecurity.csrf(AbstractHttpConfigurer:: disable);
        // Oauth configurations

        httpSecurity.oauth2Login(oauth->{
            oauth.loginPage("/login");
            oauth.successHandler(handler);
        });
        httpSecurity.logout(logoutForm->{
             logoutForm.logoutUrl("/do-logout");
             logoutForm.logoutSuccessUrl("/login?logout=true");
        });

        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
