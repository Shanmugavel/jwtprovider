/**
 * 
 */
package xyz.shanmugavel.poc.jwtprovider.web.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author shanmugavelsundaramoorthy
 *
 */
@ToString
public class User  extends BaseDTO {

	private static final long serialVersionUID = 1L;

	@Getter @Setter private String firstName;
	@Getter @Setter private String lastName;
	@Getter @Setter private String status;
	
}
