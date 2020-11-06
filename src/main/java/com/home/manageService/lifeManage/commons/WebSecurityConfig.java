package com.home.manageService.lifeManage.commons;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;


/**
 * @Package : com.home.manageService.lifeManage.commons
 * @FileName : WebSecurityConfig.java
 * @CreateDate : 2020. 11. 6. 
 * @author : park
 * @Description :webSecurity 설정 
 */
 
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  public void configure(WebSecurity web) throws Exception {
    web.ignoring().antMatchers("/static/**");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests().antMatchers("/").permitAll().antMatchers("/view", "/view/**")
        .access("hasRole('ROLE_VIEW')").anyRequest().authenticated().and().formLogin()
        .loginPage("/login").defaultSuccessUrl("/view").permitAll().usernameParameter("username")
        .passwordParameter("password").and().logout().permitAll().and().csrf()
        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
  }
}
