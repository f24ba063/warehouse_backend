package com.example.warehouse.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.warehouse.model.AppUser;
import com.example.warehouse.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AppUserDetailsService implements UserDetailsService{
	private final UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username)
	throws UsernameNotFoundException{
		AppUser user = userRepository.findByUsername(username)
				.orElseThrow(() ->
					new UsernameNotFoundException(
							"そのユーザーはいません：" + username)
						);
		
		return org.springframework.security.core.userdetails.User
				.withUsername(user.getUsername())
				.password(user.getPassword())
				.roles(user.getRole())
				.disabled(!user.isEnabled())
				.build();
	}
}
