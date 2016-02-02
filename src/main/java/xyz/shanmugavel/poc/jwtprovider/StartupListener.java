/**
 * 
 */
package xyz.shanmugavel.poc.jwtprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import xyz.shanmugavel.poc.jwtprovider.util.KeyUtil;

/**
 * @author shanmugavelsundaramoorthy
 *
 */
@Component
@Slf4j
public class StartupListener implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private Environment env;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		log.info("Env={}", env);
		log.info("SigningKey={}", env.getProperty("SigningKey"));
		log.info("DecodedKey={}", KeyUtil.decodeKey(env.getProperty("SigningKey")));
	}

}