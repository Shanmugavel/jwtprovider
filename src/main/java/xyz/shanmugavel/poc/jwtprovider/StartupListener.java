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
		jwt.setIssuer("Shan");
		jwt.setSubject("UIApp");
		jwt.setSignatureAlg(SignatureAlgorithm.HS512);
		String jwtoken = KeyUtil.createJWT(jwt, env.getProperty("SigningKey"));
		log.info("GeneratedJWT={}", jwtoken);
		log.info("isValidJWT={}", KeyUtil.isValidJWT(jwtoken, env.getProperty("SigningKey")) );
		log.info("stormpath.web.accessToken.enabled={}", env.getProperty("stormpath.web.accessToken.enabled"));
		log.info("stormpath.spring.security.enabled={}", env.getProperty("stormpath.spring.security.enabled"));
		log.info("stormpath.web.login.enabled={}", env.getProperty("stormpath.web.login.enabled"));
		log.info("stormpath.web.enabled={}", env.getProperty("stormpath.web.enabled"));
		log.info("stormpath.web.csrf.token.enabled={}", env.getProperty("stormpath.web.csrf.token.enabled"));
		log.info("stormpath.web.idSite.enabled={}", env.getProperty("stormpath.web.idSite.enabled"));
		log.info("stormpath.web.saml.enabled={}", env.getProperty("stormpath.web.saml.enabled"));
		log.info("stormpath.web.change.enabled={}", env.getProperty("stormpath.web.change.enabled"));
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
