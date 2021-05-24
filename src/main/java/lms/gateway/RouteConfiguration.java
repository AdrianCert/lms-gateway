package lms.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
@Configuration
public class RouteConfiguration {
    public Instances instances = Instances.getInstance();

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder){
        return builder.routes()
                //TASK-HANDLER
                .route(r -> r.path("/task/**")
                        .uri(instances.get( "TASK-HANDLER")))
                .route(r -> r.path("/professor/**")
                        .uri(instances.get( "TASK-HANDLER")))
                .route(r -> r.path("/question/**")
                        .uri(instances.get( "TASK-HANDLER")))
                .route(r -> r.path("/task_professor/**")
                        .uri(instances.get( "TASK-HANDLER")))
                .route(r -> r.path("/task_question/**")
                        .uri(instances.get( "TASK-HANDLER")))
                .route(r -> r.path("/student/**")
                        .uri(instances.get( "TASK-HANDLER")))
                .route(r -> r.path("/answer/**")
                        .uri(instances.get( "TASK-HANDLER")))
                .route(r -> r.path("/score_answer/**")
                        .uri(instances.get( "TASK-HANDLER")))
                .route(r -> r.path("/task_student/**")
                        .uri(instances.get( "TASK-HANDLER")))
                //TASK-GRADER
                .route(r -> r.path("/sheet/**")
                        .uri(instances.get( "TASK-GRADER")))
                .route(r -> r.path("/sheet_task/**")
                        .uri(instances.get( "TASK-GRADER")))
                .route(r -> r.path("/sheet_student/**")
                        .uri(instances.get( "TASK-GRADER")))
                .route(r -> r.path("/grade/**")
                        .uri(instances.get( "TASK-GRADER")))
                //JWT-MS
                .route(r -> r.path("/auth/**")
                        .uri(instances.get( "JWT")))
                .route(r -> r.path("/permission/**")
                        .uri(instances.get( "JWT")))
                //TASK-FORUM
                .route(r -> r.path("/forum/**")
                        .uri(instances.get( "FORUM")))

                //TASK-MAIL
                .route(r -> r.path("/mail/**")
                        .uri(instances.get("MAIL")))

                //CONTENT-MANAGEMENT
                .route(r -> r.path("/content_block/**")
                        .uri(instances.get( "CONTENT-MANAGER")))

                .route(r -> r.path("/course/**")
                        .uri(instances.get( "CONTENT-MANAGER")))

                .route(r -> r.path("/subject/**")
                        .uri(instances.get( "CONTENT-MANAGER")))

                .route(r -> r.path("/subject_course/**")
                        .uri(instances.get( "CONTENT-MANAGER")))

                .route(r -> r.path("/api/task-handler/**")
                        .filters(f -> f.rewritePath("/api/task-handler/(?<path>.*)", "/${path}"))
                        .uri(instances.get("TASK-HANDLER")))
                .route(r -> r.path("/api/task-grader/**")
                        .filters(f -> f.rewritePath("/api/task-grader/(?<path>.*)", "/${path}"))
                        .uri(instances.get( "TASK-GRADER")))
                .route(r -> r.path("/api/content/**")
                        .filters(f -> f.rewritePath("/api/content/(?<path>.*)", "/${path}"))
                        .uri(instances.get( "CONTENT-MANAGER")))
                .route(r -> r.path("/api/forum/**")
                        .filters(f -> f.rewritePath("/api/forum/(?<path>.*)", "/${path}"))
                        .uri(instances.get( "FORUM")))
                .route(r -> r.path("/api/jwt/**")
                        .filters(f -> f.rewritePath("/api/jwt/(?<path>.*)", "/${path}"))
                        .uri(instances.get( "JWT")))
                .route(r -> r.path("/api/mail/**")
                        .filters(f -> f.rewritePath("/api/mail/(?<path>.*)", "/${path}"))
                        .uri(instances.get( "MAIL")))
                .build();
    }
}
