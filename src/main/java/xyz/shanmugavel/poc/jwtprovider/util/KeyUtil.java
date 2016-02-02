/**
 * 
 */
package xyz.shanmugavel.poc.jwtprovider.util;

import java.security.Key;
import java.util.Base64;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import lombok.extern.slf4j.Slf4j;

/**
 * @author shanmugavelsundaramoorthy
 *
 */
@Slf4j
public class KeyUtil {

	public static String generateSigningKey(SignatureAlgorithm signAlg) {
		Key key = MacProvider.generateKey(signAlg);
    	String encodedKey = Base64.getEncoder().encodeToString(key.getEncoded());
    	log.info("encodedKey={}", encodedKey);
    	return encodedKey;
	}
	
	public static byte[] decodeKey(String encodedKey) {
		byte[] decodedKey = Base64.getDecoder().decode(encodedKey);
		log.debug("decodedKey={}", decodedKey);
		return decodedKey;
	}
}
