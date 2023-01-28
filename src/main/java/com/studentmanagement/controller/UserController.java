package com.studentmanagement.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.studentmanagement.model.User;
import com.studentmanagement.repository.UserRepository;


@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/user")
	User newUser(@RequestBody User newUser) {
		return userRepository.save(newUser);
	}
	
	@GetMapping("/users")
	List<User> getAllUsers(){
		return (List<User>) userRepository.findAll();
	}
	
	@GetMapping("/user/{id}")
	Optional<User> getUserById(@PathVariable Long id) {
		return userRepository.findById(id);
	}
	
	@PutMapping("/user/{id}")
	Stream<User> updateUser(@RequestBody User newUser,@PathVariable Long id) {
		return userRepository.findById(id).stream().map(b->{
			b.setUsername(newUser.getUsername());
			b.setEmail(newUser.getEmail());
			b.setName(newUser.getName());
			userRepository.save(b);
			return b;
		});
		
	
		
	}
	 @DeleteMapping("/user/{id}")
	 String deleteUser(@PathVariable Long id) {
		 userRepository.deleteById(id);
		 return "Uset with id" + id + "has been deleted succesfully";
	 }
	
}
 