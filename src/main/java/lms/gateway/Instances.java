package lms.gateway;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.LinkedList;

@Component
public class Instances {

    private static Instances instance = null;
    private final HashMap<String, Integer> roundBounder = new HashMap<>();
    private final HashMap<String, LinkedList<String>> instances = new HashMap<>();
    private final HashMap<String, Integer> maxBounder = new HashMap<>();

    private Instances() {
        add( "TASK-HANDLER",    "https://tbd-dev.herokuapp.com/");
        add( "TASK-GRADER",     "https://tbd-dev2.herokuapp.com/");
        add( "FORUM",           "https://lms-forum-app.herokuapp.com/");
        add( "MAIL",            "https://mail-microservice.herokuapp.com/");
        add( "JWT",             "https://jwtlms.herokuapp.com/");
        add( "CONTENT-MANAGER", "https://tbd-dev3.herokuapp.com/");
    }

    public static Instances getInstance() {
        if( instance == null) {
            instance = new Instances();
        }
        return instance;
    }

    private void add(String appName, String appValue) {
        if(!maxBounder.containsKey(appName)) {
            maxBounder.put(appName, 0);
            instances.put(appName, new LinkedList<>());
        }

        instances.get(appName).add(appValue);
        maxBounder.put(appName,  maxBounder.get(appName) + 1);
    }

    public String get(String appName) {

        if(!roundBounder.containsKey(appName)) {
            roundBounder.put(appName, 0);
        }

        int current = roundBounder.get(appName);
        int counter = maxBounder.get(appName);

        if( current == counter) current = 0;

        roundBounder.put(appName, current + 1);
        return instances.get(appName).get(counter);
    }
}
