package lms.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfiguration {
    private static final String API_TASK_HANDLER = "https://tbd-dev.herokuapp.com/";

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder){
        return builder.routes()
                .route(r -> r.path("/task/**")
                        .uri(API_TASK_HANDLER))
                .route(r -> r.path("/professor/**")
                        .uri(API_TASK_HANDLER))
                .route(r -> r.path("/question/**")
                        .uri(API_TASK_HANDLER))
                .route(r -> r.path("/task_professor/**")
                        .uri(API_TASK_HANDLER))
                .route(r -> r.path("/task_question/**")
                        .uri(API_TASK_HANDLER))
                .build();
    }
}
