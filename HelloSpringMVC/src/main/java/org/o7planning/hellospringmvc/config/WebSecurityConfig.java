package org.o7planning.hellospringmvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.transaction.annotation.Transactional;





@Configuration
@EnableWebSecurity
@Transactional
public class WebSecurityConfig extends WebSecurityConfigurerAdapter  {
	
		@Autowired
	   private MyUserDetailsService myUserDetailsService;
	 
	   @Autowired
	   public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	       auth.userDetailsService(myUserDetailsService);
	   }
	   
	   @Override
	    protected void configure(HttpSecurity http) throws Exception {
		   System.out.println("WebSecurityConfig ok");
	        http.authorizeRequests()
	                .antMatchers("/login","/logout").permitAll()
	                .antMatchers("/","/user/getall").hasAnyRole("ADMIN","USER")
	                .antMatchers("/user/create","/user/update","/user/delete").hasRole("ADMIN")
	                .and()
	                .formLogin()
	                .loginPage("/login")
	                .loginProcessingUrl("/loginAction")
	                .defaultSuccessUrl("/" , true)
	                .failureUrl("/login")
	                .and()
	                .logout().logoutSuccessUrl("/login")
	                .and()
	                .csrf().disable()
	                .exceptionHandling().accessDeniedPage("/403");
	    }  
}
