package com.example.geektrust.service.impl;

import com.example.geektrust.model.Course;
import com.example.geektrust.service.ICommandService;
import com.example.geektrust.util.Constant;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AddCourse implements ICommandService {
    @Override
    public void execute(TreeMap<String, Course> courseMap, Map<String, Course> registeredEmployeeCourseMap, List<String> parameteres) throws Exception {
        if (parameteres.size() != Constant.ADD_COURSE_PARAMETER_SIZE) {
            throw new Exception("INPUT_DATA_ERROR");
        }
        String courseName = parameteres.get(0);
        String courseTeacher = parameteres.get(1);
        String time = parameteres.get(2);
        DateFormat df = new SimpleDateFormat("ddMMyyyy");
        Date startDate = df.parse(time);
        int minRequirement = Integer.parseInt(parameteres.get(3));
        int maxRequirement = Integer.parseInt(parameteres.get(4));
        Course course = new Course();
        course.set"OFFERING-" + courseName + "-" + courseTeacher, courseName, courseTeacher,
                startDate, minRequirement, maxRequirement);
        addToCourse(courseMap, course);
    }

    private void addToCourse(Map<String, Course> courseMap, Course course) {
        courseMap.put(course.getCourseId(), course);
        System.out.println(course.getCourseId());
    }
}
