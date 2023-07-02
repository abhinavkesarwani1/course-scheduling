package com.example.geektrust.service.impl;

import com.example.geektrust.model.Course;
import com.example.geektrust.model.Employee;
import com.example.geektrust.service.ICommandService;
import com.example.geektrust.util.Constant;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Allot implements ICommandService {
    @Override
    public void execute(TreeMap<String, Course> courseMap, Map<String, Course> registeredEmployeeCourseMap, List<String> parameteres) throws Exception {
//        ALLOT OFFERING-JAVA-JAMES
        if (parameteres.size() != Constant.ALLOT_PARAMETER_SIZE) {
            throw new Exception("INVALID_INPUT_DATA");
        }
        String courseId = parameteres.get(0);
        Course course = courseMap.get(courseId);
        if (course != null) {
            if (course.getRegisteredEmployees().size() < course.getMinCapacity()) {
                course.setCancelled(true);
                printCourseData(course);
            } else {
                course.setAlloted(true);
                printCourseData(course);
            }
        } else {
            throw new Exception("INPUT_DATA_ERROR");
        }
    }

    private void printCourseData(Course course) {
        String status = course.isCancelled() ? "COURSE_CANCELED" : "CONFIRMED";
        for (Map.Entry<String, Employee> e : course.getRegisteredEmployees().entrySet()) {
            String pattern = "ddMMyyyy";
            DateFormat df = new SimpleDateFormat(pattern);
            System.out.println(e.getKey() + " " + e.getValue().getEmailAddress() + " " + course.getCourseId() + " " +
                    course.getCourseName() + " " + course.getInstructor() + " "
                    + df.format(course.getDate()) + " " + status);
        }
    }

}
