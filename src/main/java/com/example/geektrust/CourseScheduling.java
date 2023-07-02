package com.example.geektrust;

import com.example.geektrust.model.Course;
import com.example.geektrust.service.CommandServiceExecutor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CourseScheduling {

    private static final CourseScheduling courseScheduling = null;
    private final TreeMap<String, Course> courseMap;
    private final Map<String, Course> registeredEmployeeCourseMap;

    private CourseScheduling() {
        courseMap = new TreeMap<>();
        registeredEmployeeCourseMap = new HashMap<>();
    }

    synchronized public static CourseScheduling getInstance() {
        if (courseScheduling == null) {
            synchronized (CourseScheduling.class) {
                if (courseScheduling == null) {
                    return new CourseScheduling();
                }
            }
        }
        return courseScheduling;
    }

    public void executeCommand(String command, List<String> parameters) throws Exception {
        CommandServiceExecutor commandServiceExecutor = new CommandServiceExecutor();
        try {
            commandServiceExecutor.getCommandExecutor(command).execute(courseMap, registeredEmployeeCourseMap, parameters);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            //throw e;
        }
    }
}
