package com.sowmya.librarysystem.config;

import com.sowmya.librarysystem.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {



   private UserService userService;

   public SecurityConfiguration(@Lazy UserService userService)
   {
       super();
       this.userService=userService;
   }

    @Bean
    public BCryptPasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authenticationProvider());
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
     http.authorizeRequests()
                .antMatchers("/addBookForm","/showFormForUpdateBook",
                        "/deleteBook","/saveBook"
                ,"/addCategoryForm","/saveCategory"
                ,"/showFormForUpdateCategory"
                ,"/deleteCategory")
             .hasAuthority("ROLE_LIBRARIAN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/loginForm")
                .loginProcessingUrl("/welcome")
             .defaultSuccessUrl("/welcome")
                .permitAll()
                .and()
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
             .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
             .logoutSuccessUrl("/logoutSuccess")
             .deleteCookies("JSESSIONID")
             .permitAll();



    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/home");
    }
}
