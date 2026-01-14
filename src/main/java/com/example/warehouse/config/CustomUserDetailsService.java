package com.example.warehouse.config;

import java.util.Collections;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.warehouse.model.AppUser;
import com.example.warehouse.repository.UserRepository;

import lombok.RequiredArgsConstructor;

//このアプリではユーザー情報はどこからどう獲るのか、を教える

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
	
	private final UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException{
		AppUser user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("ユーザーが見つかりません:"+username));
		
		return org.springframework.security.core.userdetails.User.builder()
				.username(user.getUsername())
				.password(user.getPassword())
				.authorities(Collections.singleton(new SimpleGrantedAuthority(user.getRole())))
				.accountExpired(false)
				.accountLocked(false)
				.credentialsExpired(false)
				.disabled(!user.getEnabled())
				.build();
	}
}
