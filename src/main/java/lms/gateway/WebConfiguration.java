package lms.gateway;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SinglePurposeIntercepor()).addPathPatterns("/task/**", "/task/**", "/task_professor/**", "/question/**", "/task_question/**");
    }
}
