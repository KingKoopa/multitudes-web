package cl.cleardigital.web.multitudes.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import cl.cleardigital.web.multitudes.interceptor.LoggerInterceptor;


@Configuration
@EnableWebMvc
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {

	@Bean
	public LoggerInterceptor loggerInterceptor() {
		return new LoggerInterceptor();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loggerInterceptor()).addPathPatterns("/**").excludePathPatterns("/resources/**");
	}
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(
                "/webjars/**",
                "/img/**",
                "/images/**",
                "/css/**",
                "/js/**",
                "/fonts/**",
                "/vendors/**",
                "/lib/**")
                .addResourceLocations(
                        "classpath:/META-INF/resources/webjars/",
                        "classpath:/static/img/",
                        "classpath:/static/css/",
                        "classpath:/static/js/",
                        "classpath:/static/fonts/",
                        "classpath:/static/vendors/",
                        "classpath:/static/lib/");
    }
}
