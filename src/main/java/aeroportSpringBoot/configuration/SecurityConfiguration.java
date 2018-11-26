package aeroportSpringBoot.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

//	@Autowired
//	private CustomUserDetailService userDetailService;

//	 definition des pages securisees
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/accueil/").permitAll();
		http.authorizeRequests().antMatchers("/client/").permitAll();
		http.authorizeRequests().antMatchers("/passager/").permitAll();
		http.authorizeRequests().antMatchers("/personne/").permitAll();
		http.authorizeRequests().antMatchers("/reservations/").permitAll();
		http.authorizeRequests().antMatchers("/vol/").permitAll();
		
//		http.authorizeRequests().antMatchers("/personne/**").authenticated().and().formLogin().loginPage("/login")
//				.failureUrl("/login?error=erreur").permitAll().and().logout().permitAll()
//				.logoutSuccessUrl("/personne/");
//		http.authorizeRequests().antMatchers("/rest/**").authenticated().and().httpBasic();
//		http.csrf().disable();
//		http.headers().frameOptions().disable();
	}

//	// definition de la methode d'authentification # methode 1
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("tanguy").password("{noop}root").roles("ADMIN"); // ici on indique que le
//																								// password n'est pas
//																								// crypte		
//	}

//	// definition de la methode d'authentification # methode 2
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.jdbcAuthentication().dataSource(dataSource)
//				.usersByUsernameQuery("select username, password, enable from users where username=?")
//				.authoritiesByUsernameQuery("select username, role from user_role where username=?");
//	}

	// definition de la methode d'authentification # methode 3 (a utiliser)
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(userDetailService).passwordEncoder(getPasswordEncoder());
//	}

	// definition de la methode de cryptage du password
	@Bean(name = "passwordEncoder")
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
