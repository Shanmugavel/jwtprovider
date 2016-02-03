/**
 * 
 */
package xyz.shanmugavel.poc.jwtprovider.service;

import java.util.List;

import xyz.shanmugavel.poc.jwtprovider.web.dto.User;

/**
 * @author shanmugavelsundaramoorthy
 *
 */
public interface IUserService extends IBaseService<User> {

	User create(User entity);
	User update(User entity);
	void delete(Long id);
	User getById(Long id);
	List<User> getAllUsers();
	
}
