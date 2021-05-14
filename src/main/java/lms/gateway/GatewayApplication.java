package lms.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;

@Configuration
@SpringBootApplication
@EnableEurekaClient
@CrossOrigin("http://localhost:4200")
public class GatewayApplication {
////nou
//	@Bean
//	public WebMvcConfigurer configure(){
//		return new WebMvcConfigurer(){
//			@Override
//			public void addCorsMappings(CorsRegistry registry){
//				registry.addMapping("/*").allowedOrigins("http://localhost:4200");
//			}
//		};
//	}
////ce era deja


    public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
}
