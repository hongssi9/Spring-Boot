package com.newlecture.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

//@Controller
//@Service
//@Repository
//@Configuration
//@Component
//새로생성하는건 이렇게

// Bean Container(콩자루, 콩보따리) : IoC Container
@Configuration // 구성요소 : 스프링 어플리케이션을 구성하는 객체들
public class TilesConfig {
	
	@Bean
	public TilesConfigurer tilesConfigurer() { //tilesConfigurer 아무렇게 만들어도 되지만..디폴트 이름이 앞에는 소문자 나머지는 같게해서
		
		TilesConfigurer config = new TilesConfigurer();
		config.setDefinitions(new String[]{
				"/WEB-INF/tiles.xml"		
	});
		return config;
	}
	
	
	@Bean //아래 함수 반함값을 메모리에 올려주기 위해서 //남이만든걸 Bean에다 담는다 대신! 이름을 만들어서 알려줘~
	public TilesViewResolver tilesViewResolver() { //2.이름이 이 함수 이름
		
		TilesViewResolver resolver = new TilesViewResolver(); //남이만든건 이걸로
		resolver.setViewClass(TilesView.class);
		resolver.setOrder(1); //우선순위1번
		
		return resolver; //요게 메모리로 올라감->1.스프링에 메모리를 올리기위해서는 이름이 필요해
	}


}
