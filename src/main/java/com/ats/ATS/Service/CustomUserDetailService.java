package com.ats.ATS.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ats.ATS.Repository.UserRepository;
import com.ats.ATS.model.User;

@Service
public class CustomUserDetailService implements UserDetailsService{

	@Autowired
	private UserRepository userrepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user= userrepo.findByEmail(username).orElseThrow(()-> new RuntimeException("User not found!!"));
		
		return user;
	}

}
