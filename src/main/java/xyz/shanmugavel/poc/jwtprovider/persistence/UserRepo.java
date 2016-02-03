/**
 * 
 */
package xyz.shanmugavel.poc.jwtprovider.persistence;

import org.springframework.data.repository.PagingAndSortingRepository;

import xyz.shanmugavel.poc.jwtprovider.persistence.model.User;

/**
 * @author shanmugavelsundaramoorthy
 *
 */
public interface UserRepo extends PagingAndSortingRepository<User, Long> {

}
