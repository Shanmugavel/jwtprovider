/**
 * 
 */
package xyz.shanmugavel.poc.jwtprovider.web.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * @author shanmugavelsundaramoorthy
 *
 */
public abstract class BaseDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	@Getter @Setter private Long id;
	
}
