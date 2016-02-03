/**
 * 
 */
package xyz.shanmugavel.poc.jwtprovider.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import xyz.shanmugavel.poc.jwtprovider.persistence.UserRepo;
import xyz.shanmugavel.poc.jwtprovider.persistence.model.User;

/**
 * @author shanmugavelsundaramoorthy
 *
 */
@Service
@Slf4j
public class UserService implements IUserService {

	@Autowired
	private UserRepo userRepo;

	@Override
	@Transactional(readOnly = true)
	public User findById(Long id) {
		return userRepo.findOne(id);
	}

	@Override
	public User create(User entity) {
		log.info("Saving... {}", entity);
		return userRepo.save(entity);
	}

	@Override
	public User update(User entity) {
		log.info("Updating ... {}", entity);
		return userRepo.save(entity);
	}

	@Override
	public void delete(Long id) {
		userRepo.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public User getById(Long id) {
		return userRepo.findOne(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<User> getAllUsers() {
		List<User> lstUsers = new ArrayList<>();
		userRepo.findAll().forEach(lstUsers::add);
		return lstUsers;
	}

}
