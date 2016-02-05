/**
 * 
 */
package xyz.shanmugavel.poc.jwtprovider.util;

import java.io.Serializable;

import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author shanmugavelsundaramoorthy
 *
 */
@ToString
public class JWTModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Getter @Setter private String id;
	@Getter @Setter private String issuer;
	@Getter @Setter private String subject;
	@Getter @Setter private long expirationDate;
	@Getter @Setter private long issuedAt;
	@Getter @Setter private SignatureAlgorithm signatureAlg;
	
}
