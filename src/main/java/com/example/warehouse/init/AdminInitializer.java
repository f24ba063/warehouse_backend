package com.example.warehouse.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.warehouse.model.AppUser;
import com.example.warehouse.repository.UserRepository;

//アプリ起動時に初期管理者ユーザーがもし存在しないときに
//自動生成するための初期化処理
@Component
public class AdminInitializer implements CommandLineRunner{
	private final UserRepository userRepository;
	private final BCryptPasswordEncoder passwordEncoder;
	
	public AdminInitializer(UserRepository userRepository,
			BCryptPasswordEncoder passwordEncoder) {
				this.userRepository = userRepository;
				this.passwordEncoder = passwordEncoder;
	}
	@Override
	@Transactional
	public void run(String... args)throws Exception{
		String adminUsername = "admin";
		
		boolean exists = userRepository.existsByUsername(adminUsername);
		if(!exists) {
			var admin = new AppUser();
			admin.setUsername(adminUsername);
			admin.setPassword(passwordEncoder.encode("admin123"));
			admin.setRole("ROLE_ADMIN");
			admin.setEnabled(true);
			userRepository.save(admin);
			System.out.println("初期adminユーザーを作成しました。");
		}
	}
}
