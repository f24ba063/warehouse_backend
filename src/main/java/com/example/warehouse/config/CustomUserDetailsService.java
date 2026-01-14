package com.example.warehouse.config;

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
				.orElseThrow(() -> 
				new UsernameNotFoundException("ユーザーが見つかりません:"+username));
		
        // DB に ROLE_ADMIN, ROLE_USER がそのまま入っている場合
        String roleWithoutPrefix = user.getRole().replace("ROLE_", "");

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .roles(roleWithoutPrefix)   // ここで ROLE_ を除去
                .disabled(!user.isEnabled())
                .build();
	}
}
