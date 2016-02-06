/**
 * 
 */
package xyz.shanmugavel.poc.jwtprovider.security;

import static com.stormpath.spring.config.StormpathWebSecurityConfigurer.stormpath;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author shanmugavelsundaramoorthy
 *
 */

@Configuration
public class SecurityConfigAdapter extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.apply(stormpath());
	}
}
