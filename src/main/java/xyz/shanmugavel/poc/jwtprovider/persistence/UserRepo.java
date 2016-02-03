/**
 * 
 */
package xyz.shanmugavel.poc.jwtprovider.persistence;

import org.springframework.data.repository.PagingAndSortingRepository;

import xyz.shanmugavel.poc.jwtprovider.persistence.model.UserEntity;

/**
 * @author shanmugavelsundaramoorthy
 *
 */
public interface UserRepo extends PagingAndSortingRepository<UserEntity, Long> {

}
