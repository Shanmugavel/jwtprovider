/**
 * 
 */
package xyz.shanmugavel.poc.jwtprovider.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import xyz.shanmugavel.poc.jwtprovider.persistence.UserRepo;
import xyz.shanmugavel.poc.jwtprovider.persistence.model.UserEntity;
import xyz.shanmugavel.poc.jwtprovider.web.dto.User;

/**
 * @author shanmugavelsundaramoorthy
 *
 */
@Service
@Slf4j
public class UserService implements IUserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	@Transactional(readOnly = true)
	public User findById(Long id) {
		return modelMapper.map(userRepo.findOne(id), User.class);
	}

	@Override
	public User create(User entity) {
		log.info("Saving... {}", entity);
		UserEntity usrEntity = modelMapper.map(entity, UserEntity.class);
		usrEntity.setCreateDate(LocalDateTime.now());
		userRepo.save(usrEntity);
		return modelMapper.map(usrEntity, User.class);
	}

	@Override
	public User update(User entity) {
		log.info("Updating ... {}", entity);
		UserEntity usrEntity = modelMapper.map(entity, UserEntity.class);
		userRepo.save(usrEntity);
		return modelMapper.map(usrEntity, User.class);	
	}

	@Override
	public void delete(Long id) {
		userRepo.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public User getById(Long id) {
		return modelMapper.map(userRepo.findOne(id), User.class);
	}

	@Override
	@Transactional(readOnly = true)
	public List<User> getAllUsers() {
		List<User> lstUsers = new ArrayList<>();
		userRepo.findAll().forEach(usr -> { lstUsers.add(modelMapper.map(usr, User.class)); });
		return lstUsers;
	}

}
