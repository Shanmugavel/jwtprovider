/**
 * 
 */
package xyz.shanmugavel.poc.jwtprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import xyz.shanmugavel.poc.jwtprovider.util.JWTModel;
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
		log.info("DATABASE_URL={}", env.getProperty("DATABASE_URL"));
		JWTModel  jwt = new JWTModel();
		jwt.setId("");
		jwt.setIssuer("Shaan");
		jwt.setSubject("UIApp");
		jwt.setSignatureAlg(SignatureAlgorithm.HS512);
		log.info("GeneratedJWT={}", KeyUtil.createJWT(jwt, env.getProperty("SigningKey")));
		/*User user = new User();
		user.setFirstName("Shanmugavel");
		user.setLastName("Sundaramoorthy");
		user.setStatus("Active");
		user.setCreateDate(LocalDateTime.now());
		user = userSvc.create(user);
		log.info("User={}", user);
		log.info("Before Deletion AllUsers={}", userSvc.getAllUsers());
		userSvc.delete(user.getId());
		log.info("After Deletion AllUsers={}", userSvc.getAllUsers());*/
	}

}
