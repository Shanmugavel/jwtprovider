/**
 * 
 */
package xyz.shanmugavel.poc.jwtprovider.service;

/**
 * @author shanmugavelsundaramoorthy
 *
 */
public interface IBaseService<T> {
	
	T findById(Long id);
	
}
