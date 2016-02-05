/**
 * 
 */
package xyz.shanmugavel.poc.jwtprovider.util;

import java.security.Key;
import java.time.Clock;
import java.time.ZonedDateTime;
import java.util.Base64;
import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import lombok.extern.slf4j.Slf4j;

/**
 * @author shanmugavelsundaramoorthy
 *
 */
@Slf4j
public class KeyUtil {

	private static final int EXPIRATION_TIME_IN_MNS = 10;
	
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
	
	public static String createJWT(JWTModel jwtToken, String encodedKey) {
		JwtBuilder builder  = Jwts.builder().setIssuer(jwtToken.getIssuer())
				.setSubject(jwtToken.getSubject()).setIssuedAt(Date.from(ZonedDateTime.now(Clock.systemUTC()).toInstant()))
				.setExpiration(Date.from(ZonedDateTime.now(Clock.systemUTC()).plusMinutes(EXPIRATION_TIME_IN_MNS).toInstant())).signWith(jwtToken.getSignatureAlg(), encodedKey);
		log.info(builder.toString());
		return builder.compact();
	}
	
	public static boolean isValidJWT(String jwt, String encodedKey) {
		boolean isValid = false;
		Claims claims = Jwts.parser().setSigningKey(encodedKey).parseClaimsJws(jwt).getBody();
		log.info("issuer={}, subject={} issuedAt={} expDt={}", claims.getIssuer(), claims.getSubject(), claims.getIssuedAt(), claims.getExpiration());
		if ("Shan".equals(claims.getIssuer())) {
			isValid = true;
		}
		
		return isValid;
	}
}
