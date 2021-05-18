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
                //TASK-GRADER
                .route(r -> r.path("/sheet/**")
                        .uri(API_TASK_GRADER))
                .route(r -> r.path("/sheet_task/**")
                        .uri(API_TASK_GRADER))
                .route(r -> r.path("/sheet_student/**")
                        .uri(API_TASK_GRADER))
                //JWT-MS
                .route(r -> r.path("/auth/**")
                        .uri(API_JWT_MS))
                .route(r -> r.path("/permission/**")
                        .uri(API_JWT_MS))
                //TASK-FORUM
                .route(r -> r.path("/forum/**")
                        .uri(API_FORUM_MS))
                /* -- FORUM ROUTE -- * /
                .route(r -> r.path("/allForums/**")
                        .uri(API_FORUM_MS))
                .route(r -> r.path("/addForum/**")
                        .uri(API_FORUM_MS))
                .route(r -> r.path("/updateForumName/**")
                        .uri(API_FORUM_MS))
                .route(r -> r.path("/updateForumTopic/**")
                        .uri(API_FORUM_MS))
                .route(r -> r.path("/deleteForum/**")
                        .uri(API_FORUM_MS))
                .route(r -> r.path("/question/**")
                        .uri(API_FORUM_MS))
                .route(r -> r.path("/allQuestions/**")
                        .uri(API_FORUM_MS))
                .route(r -> r.path("/addQuestion/**")
                        .uri(API_FORUM_MS))
                .route(r -> r.path("/updateQuestionTitle/**")
                        .uri(API_FORUM_MS))
                .route(r -> r.path("/updateQuestionContent/**")
                        .uri(API_FORUM_MS))
                .route(r -> r.path("/upvoteQuestion/**")
                        .uri(API_FORUM_MS))
                .route(r -> r.path("/downvoteQuestion/**")
                        .uri(API_FORUM_MS))
                .route(r -> r.path("/deleteQuestion/**")
                        .uri(API_FORUM_MS))
                .route(r -> r.path("/comment/**")
                        .uri(API_FORUM_MS))
                .route(r -> r.path("/allComments/**")
                        .uri(API_FORUM_MS))
                .route(r -> r.path("/addComment/**")
                        .uri(API_FORUM_MS))
                .route(r -> r.path("/upvoteComment/**")
                        .uri(API_FORUM_MS))
                .route(r -> r.path("/downvoteComment/**")
                        .uri(API_FORUM_MS))
                .route(r -> r.path("/updateCommentContent/**")
                        .uri(API_FORUM_MS))
                .route(r -> r.path("/deleteComment/**")
                        .uri(API_FORUM_MS))
                .route(r -> r.path("/deleteAllComments/**")
                        .uri(API_FORUM_MS))
                /* -- END FORUM ROUTE -- */

                //TASK-MAIL
                .route(r -> r.path("/mail/**")
                        .uri(API_MAIL_MS))

                .build();
    }
}
