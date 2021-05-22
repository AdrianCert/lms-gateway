package lms.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;


@CrossOrigin(origins = "http://localhost:4200")
@Configuration
public class RouteConfiguration {
    private static final String API_TASK_HANDLER = "https://tbd-dev.herokuapp.com/";
    private static final String API_TASK_GRADER = "https://tbd-dev2.herokuapp.com/";
    private static final String API_FORUM_MS = "https://lms-forum-app.herokuapp.com/";
    private static final String API_MAIL_MS = "https://mail-microservice.herokuapp.com/";
    private static final String API_JWT_MS = "https://jwtlms.herokuapp.com/";
    private static final String API_CONTENT_MANAGER = "https://tbd-dev3.herokuapp.com/";

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder){
        return builder.routes()
                //TASK-HANDLER
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
                .route(r -> r.path("/student/**")
                        .uri(API_TASK_HANDLER))
                .route(r -> r.path("/answer/**")
                        .uri(API_TASK_HANDLER))
                .route(r -> r.path("/score_answer/**")
                        .uri(API_TASK_HANDLER))
                .route(r -> r.path("/task_student/**")
                        .uri(API_TASK_HANDLER))
                //TASK-GRADER
                .route(r -> r.path("/sheet/**")
                        .uri(API_TASK_GRADER))
                .route(r -> r.path("/sheet_task/**")
                        .uri(API_TASK_GRADER))
                .route(r -> r.path("/sheet_student/**")
                        .uri(API_TASK_GRADER))
                .route(r -> r.path("/grade/**")
                        .uri(API_TASK_GRADER))
                //JWT-MS
                .route(r -> r.path("/auth/**")
                        .uri(API_JWT_MS))
                .route(r -> r.path("/permission/**")
                        .uri(API_JWT_MS))
                //TASK-FORUM
                .route(r -> r.path("/forum/**")
                        .uri(API_FORUM_MS))

                //TASK-MAIL
                .route(r -> r.path("/mail/**")
                        .uri(API_MAIL_MS))

                //CONTENT-MANAGEMENT
                .route(r -> r.path("/content_block/**")
                        .uri(API_CONTENT_MANAGER))

                .route(r -> r.path("/course/**")
                        .uri(API_CONTENT_MANAGER))

                .route(r -> r.path("/subject/**")
                        .uri(API_CONTENT_MANAGER))

                .route(r -> r.path("/subject_course/**")
                        .uri(API_CONTENT_MANAGER))

                .route(r -> r.path("/api/task-handler/**")
                        .filters(f -> f.rewritePath("/api/task-handler/(?<path>.*)", "/${path}"))
                        .uri(API_TASK_HANDLER))
                .route(r -> r.path("/api/task-grader/**")
                        .filters(f -> f.rewritePath("/api/task-grader/(?<path>.*)", "/${path}"))
                        .uri(API_TASK_GRADER))
                .route(r -> r.path("/api/content/**")
                        .filters(f -> f.rewritePath("/api/content/(?<path>.*)", "/${path}"))
                        .uri(API_CONTENT_MANAGER))
                .route(r -> r.path("/api/forum/**")
                        .filters(f -> f.rewritePath("/api/forum/(?<path>.*)", "/${path}"))
                        .uri(API_FORUM_MS))
                .route(r -> r.path("/api/jwt/**")
                        .filters(f -> f.rewritePath("/api/jwt/(?<path>.*)", "/${path}"))
                        .uri(API_JWT_MS))
                .route(r -> r.path("/api/mail/**")
                        .filters(f -> f.rewritePath("/api/mail/(?<path>.*)", "/${path}"))
                        .uri(API_MAIL_MS))
                .build();
    }
}
