package kr.or.ddit.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Configuration
@ComponentScan(basePackages = "kr.or.ddit", useDefaultFilters = false,
			   includeFilters = @Filter(type = FilterType.ANNOTATION,
					   					classes = {Service.class, Repository.class}))
public class RootConfig {

	
}
