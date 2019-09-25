package kr.or.ddit.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import kr.or.ddit.interceptor.PerformanceCheckInterceptor;
import kr.or.ddit.interceptor.SessionCheckInterceptor;

@Configuration
@EnableWebMvc
public class InterceptorConfig extends WebMvcConfigurerAdapter{

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		PerformanceCheckInterceptor performanceCheckInterceptor = new PerformanceCheckInterceptor();
		
		registry.addInterceptor(performanceCheckInterceptor).addPathPatterns("/**");

/*
		<mvc:interceptor>
			<mvc:mapping path="/**"/>
			<mvc:exclude-mapping path="/login"/> <!-- 로그인 화면, 로그인 요청 -->
			<mvc:exclude-mapping path="/css/**"/>
			<mvc:exclude-mapping path="/js/**"/>
			<mvc:exclude-mapping path="/bootstrap/**"/>
			<mvc:exclude-mapping path="/error/**"/>
			<bean class="kr.or.ddit.interceptor.SessionCheckInterceptor"></bean>
		</mvc:interceptor>
*/
		SessionCheckInterceptor sessionCheckInterceptor = new SessionCheckInterceptor();
		registry.addInterceptor(sessionCheckInterceptor)
				.addPathPatterns("/**")
				.excludePathPatterns("/login")
				.excludePathPatterns("/css/**")
				.excludePathPatterns("/js/**")
				.excludePathPatterns("/bootstrap/**")
				.excludePathPatterns("/error/**");
		
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("language");
		registry.addInterceptor(localeChangeInterceptor)
					.addPathPatterns("/**")
					.excludePathPatterns("/login")
					.excludePathPatterns("/css/**")
					.excludePathPatterns("/js/**")
					.excludePathPatterns("/bootstrap/**")
					.excludePathPatterns("/error/**");
		
	}
}
