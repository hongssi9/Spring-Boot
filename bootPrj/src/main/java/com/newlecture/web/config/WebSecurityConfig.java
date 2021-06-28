package com.newlecture.web.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSourse;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				//.antMatchers("/admin/notice/list").hasAnyRole("ADMIN") //인증이 필요한 링크 정하기
				.antMatchers("/**").permitAll()
				.antMatchers("/admin/**").hasAnyRole("ADMIN")
				.and()
			.formLogin()
				.loginPage("/member/login")
				.and()
			.csrf()
				.disable();
				
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.jdbcAuthentication()
			.dataSource(dataSourse)
			// 사용자 정보를 가져오기
			.usersByUsernameQuery("select uid id, pwd password, 1 enabled from Member where uid=?")			
			// 그 사용자의 역할 정보를 가져오기
			.authoritiesByUsernameQuery("select m.uid id,  r.name roleId "
					+ "from Member m "
					+ "	join MemberRole mr on m.id = mr.memberId "
					+ "    join Role r on r.id = mr.roleId "
					+ "where m.uid=?");
			
		
			
		
		//auth.ldapAuthentication();
		
//		auth
//			.inMemoryAuthentication()
//			.withUser("newlec")
//				.password("{noop}111")
//				.roles("ADMIN","TEACHER")
//			.and()
//			.withUser("dragon")
//				.password("{noop}111")
//				.roles("STUDENT");
//				.and()
//			.passwordEncoder(new BCryptPasswordEncoder());
	}
}
