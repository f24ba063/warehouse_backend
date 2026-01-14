package com.example.warehouse.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

//パスワードのハッシュ形式を指定している（BCrypt)
@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            .authorizeHttpRequests(auth -> auth
                // ログイン画面
                .requestMatchers("/login").permitAll()

                // 静的リソース
                .requestMatchers(
                    "/css/**",
                    "/js/**",
                    "/images/**"
                ).permitAll()

                // それ以外はログイン必須
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/login")   // デフォルトを使うなら削っても可
                .permitAll()
            )
            .logout(logout -> logout.permitAll());

        return http.build();
    }
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
