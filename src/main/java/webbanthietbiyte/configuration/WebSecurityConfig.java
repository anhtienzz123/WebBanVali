package webbanvali.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    
		return new BCryptPasswordEncoder();
	}

	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService) // Cung cáp userservice cho spring security
		.passwordEncoder(passwordEncoder()); // cung cấp password encoder
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.cors().and().csrf().disable()
			.authorizeRequests()
        		.antMatchers("/user/**").hasAnyRole("USER", "ADMIN")
        		.antMatchers("/gio-hang/dat-hang").hasAnyRole("USER", "ADMIN")
        		.antMatchers("/admin/**").hasRole("ADMIN")
        		.anyRequest().permitAll()
				.and()
					.formLogin()
						.loginPage("/login")
						.usernameParameter("email")
						.passwordParameter("password")
						.defaultSuccessUrl("/")
						.failureUrl("/login?error")
				.and()
					.exceptionHandling()
						.accessDeniedPage("/403");
	}
	
	@Override
	public void configure(WebSecurity web) {
		web.ignoring().antMatchers("/static/**");
	}
}
