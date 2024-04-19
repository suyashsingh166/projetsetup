package com.ats.ATS.Controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ats.ATS.Config.AppConfig;
import com.ats.ATS.Repository.UserRepository;
import com.ats.ATS.Security.JwtHelper;
import com.ats.ATS.Response.*;
import com.ats.ATS.Service.UserService;
import com.ats.ATS.model.JwtRequest;
import com.ats.ATS.model.JwtResponse;
import com.ats.ATS.model.User;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
    private UserDetailsService userDetailsService;
	
	@Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager manager;
    
    @Autowired
    private UserService userService;
    


    @Autowired
    private JwtHelper helper;

    private Logger logger = LoggerFactory.getLogger(AuthController.class);
    
    
   
    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request) {
    	
        this.doAuthenticate(request.getEmail(), request.getPassword());
       

        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
        
        String username=userDetails.getUsername();
        Collection<? extends GrantedAuthority> role=userDetails.getAuthorities();
        System.out.println("role"+role);
        System.out.println(userDetails+" ???AWs");
        String token = this.helper.generateToken(userDetails);
      JwtResponse first=new JwtResponse();
     first.setJwtToken(token);
     first.setUsername(username);
      
        return new ResponseEntity<>(first, HttpStatus.OK);
    }
 
  


	private void doAuthenticate(String email, String password) {

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
        try {
            manager.authenticate(authentication);


        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(" Invalid Username or Password  !!");
        }

    }

    @ExceptionHandler(BadCredentialsException.class)
    public String exceptionHandler() {
        return "Credentials Invalid !!";
    }
    
    
    @PostMapping("/create-user")
    public ServiceResponse<?> createUser(@RequestBody User user) {
    	Optional<User> newuser=userRepository.findByEmail(user.getEmail());
    	User nuser=newuser.orElse(null);
    	if(nuser ==null) {
    		User users=userService.createUser(user);
    	return new ServiceResponse<>(new GeneralMessage<>("User Created", users, 201), HttpStatus.CREATED);
    	}
    	else
    	return new ServiceResponse<>(new GeneralMessage<>("User Already exists!!", 1, 409),
				HttpStatus.CONFLICT);
    	
    	
    }
    
    @GetMapping("getAllUsers")
    public List<User> getUser(){
    	return userService.getUsers();
    }

}