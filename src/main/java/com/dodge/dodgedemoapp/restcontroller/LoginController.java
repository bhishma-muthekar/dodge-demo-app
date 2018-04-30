package com.dodge.dodgedemoapp.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dodge.dodgedemoapp.entity.User;
import com.dodge.dodgedemoapp.model.LoginSuccess;
import com.dodge.dodgedemoapp.repository.UserRepository;

@RestController
@RequestMapping("api")
public class LoginController {
	@Autowired
	private UserRepository userRepository;

	@PostMapping("/login")
	private ResponseEntity<LoginSuccess> login(@RequestBody User user) {
		LoginSuccess loginSuccess = new LoginSuccess();
		User user2 = userRepository.findByUserNameNPassword(user.getUserName(), user.getPassword());
		if (user2 == null) {
			loginSuccess.setSuccess(false);
			loginSuccess.setMessage("Invalid User");
		} else {
			loginSuccess.setSuccess(true);
			loginSuccess.setMessage("User logged in successful");
		}
		return ResponseEntity.ok(loginSuccess);
	}
	
	@PostMapping("/save-user")
	private ResponseEntity<?> save(@RequestBody User user){
		userRepository.save(user);
		
		return ResponseEntity.ok().body(
				"New User has been saved with ID: "
						+ user.getUserName());
	}

}
