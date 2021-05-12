package lms.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfiguration {
    private static final String API_TBD = "https://tbd-dev.herokuapp.com/";
    private static final String API_FORUM_MS = "https://lms-forum-app.herokuapp.com/";
    private static final String API_MAIL_MS = "https://mail-microservice.herokuapp.com/";


    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder){
        return builder.routes()
                //TASK-HANDLER
                .route(r -> r.path("/task/**")
                        .uri(API_TBD))
                .route(r -> r.path("/professor/**")
                        .uri(API_TBD))
                .route(r -> r.path("/question/**")
                        .uri(API_TBD))
                .route(r -> r.path("/task_professor/**")
                        .uri(API_TBD))
                .route(r -> r.path("/task_question/**")
                        .uri(API_TBD))
                //TASK-GRADER
                .route(r -> r.path("/sheet/**")
                        .uri(API_TBD))
                .route(r -> r.path("/sheet_task/**")
                        .uri(API_TBD))
                .route(r -> r.path("/sheet_student/**")
                        .uri(API_TBD))
                //trebuie adaugata partea de grading - inca pe localhost

                //TASK-FORUM
                .route(r -> r.path("/forum/**")
                        .uri(API_FORUM_MS))
                //TASK-MAIL
                .route(r -> r.path("/mail/**")
                        .uri(API_MAIL_MS))

                .build();
    }
}
