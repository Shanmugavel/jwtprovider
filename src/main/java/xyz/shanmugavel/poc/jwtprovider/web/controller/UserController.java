/**
 * 
 */
package xyz.shanmugavel.poc.jwtprovider.web.controller;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import xyz.shanmugavel.poc.jwtprovider.service.IUserService;
import xyz.shanmugavel.poc.jwtprovider.web.dto.User;

/**
 * @author shanmugavelsundaramoorthy
 *
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

	@Autowired
	private IUserService userSvc;
	
	@RequestMapping(produces = {MediaType.APPLICATION_JSON}, consumes={MediaType.APPLICATION_JSON}, method = {RequestMethod.POST})
	public ResponseEntity<User> createUser(@RequestBody User user) {
		log.info("Before Creation User={}", user);
		user = userSvc.create(user);
		log.info("After creation User={}", user);
		UriBuilder uriBuilder = UriBuilder.fromUri("https://evening-headland-42529.herokuapp.com/user/{userId}");
		return  ResponseEntity.created(uriBuilder.build(user.getId())).body(user);
	}
	
	@RequestMapping(path="/{userId}", produces = {MediaType.APPLICATION_JSON}, consumes={MediaType.APPLICATION_JSON}, method = {RequestMethod.GET})
	public ResponseEntity<User> getUser(@PathVariable Long userId) {
		log.info("UserId={}", userId);
		User user = userSvc.findById(userId);
		log.info("User={}", user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
}
