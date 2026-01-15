package com.example.warehouse.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

//パスワードのハッシュ形式を指定している（BCrypt)
@Configuration
public class SecurityConfig {
	@Bean
	// このメソッドの戻り値を Spring の管理対象（Bean）として登録する
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	// Spring Security のフィルタ設定全体をここで組み立てる

	    http
	        // CORS 設定を有効化し、詳細は別 Bean（CorsConfigurationSource）に任せる
	        .cors(Customizer.withDefaults())

	        // CSRF 対策を無効化（SPA + Cookie 認証ではよくやる）
	        .csrf(csrf -> csrf.disable())

	        // リクエストURLごとの認可ルール定義
	        .authorizeHttpRequests(auth -> auth

	            // /login というURLへのアクセスは「未ログインでも許可」
	            .requestMatchers("/login").permitAll()

	            // 上記以外のすべてのURLは「認証必須」
	            .anyRequest().authenticated()
	        )

	        // フォームログイン（ID/パスワード認証）の設定
	        .formLogin(form -> form

	            // ログイン処理を受け付けるURL（Controllerは不要、Securityが処理）
	            .loginProcessingUrl("/login")

	            // ログイン成功時の処理（ここではHTTP 200を返すだけ）
	            .successHandler((req, res, auth) -> {
	                res.setStatus(200);
	            })

	            // ログイン失敗時の処理（認証失敗なので401）
	            .failureHandler((req, res, ex) -> {
	                res.setStatus(401);
	            })

	            // ログイン処理URL自体へのアクセスは常に許可
	            .permitAll()
	        )

	        // ログアウトURLへのアクセスを常に許可
	        .logout(logout -> logout.permitAll());

	    // ここまで設定した内容を元に SecurityFilterChain を生成
	    return http.build();
	}

	@Bean
	// パスワードをハッシュ化・検証するためのエンコーダを Bean 登録
	BCryptPasswordEncoder passwordEncoder() {
	    // BCrypt アルゴリズムを使う実装を生成
	    return new BCryptPasswordEncoder();
	}
	
	// React(5173) からのアクセスを許可するための CORS 設定
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
	// CORS 設定を提供する Bean（SecurityFilterChain から参照される）

	    CorsConfiguration config = new CorsConfiguration();
	    // CORS の個別設定を入れるための設定オブジェクト

	    config.setAllowedOrigins(List.of("http://localhost:5173"));
	    // アクセスを許可するオリジン（フロントエンドのURL）

	    config.setAllowedMethods(List.of("GET","POST","PUT","PATCH","DELETE","OPTIONS"));
	    // 許可するHTTPメソッド

	    config.setAllowedHeaders(List.of("*"));
	    // 許可するリクエストヘッダ（全部）

	    config.setAllowCredentials(true);
	    // Cookie（JSESSIONIDなど）を含むリクエストを許可

	    UrlBasedCorsConfigurationSource source =
	            new UrlBasedCorsConfigurationSource();
	    // URLパターンごとに CORS 設定を紐づけるための入れ物

	    source.registerCorsConfiguration("/**", config);
	    // 全URL（SecurityFilterが通る範囲）にこのCORS設定を適用

	    return source;
	    // Security に渡す CORS 設定の完成形
	}
}
