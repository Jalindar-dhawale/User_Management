package com.jalindar.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jalindar.model.UserDtls;
import com.jalindar.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserRepository useRepo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		UserDtls user=useRepo.findByEmail(email);
		if(user!=null)
		{
			return new CustomUserDetails(user);
		}
		throw new UsernameNotFoundException("user not available");
	}

}
