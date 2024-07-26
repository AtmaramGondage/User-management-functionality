package Com.atm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	


	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService userDetailsservice(){
		
		UserDetails user =User
				.withUsername("atm")
				.password(passwordEncoder().encode("atm@123"))
				.roles("USER")
				.build();
		
		UserDetails admin= User
				.withUsername("nilesh")
				.password(passwordEncoder().encode("nilesh@123"))
				.roles("ADMIN")
				.build();
		
		InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager(admin,user);
		
				return inMemoryUserDetailsManager; 
		
	}
	
	
	@Bean
	public SecurityFilterChain securityConfig(HttpSecurity http) throws Exception {
			
		http.authorizeHttpRequests( (req) -> req
				.requestMatchers("/admin**").hasRole("ADMIN")
				.requestMatchers("/user").hasAnyRole("ADMIN","USER")
				.anyRequest().authenticated()
		).formLogin();
		
		return http.build();
	}

}
