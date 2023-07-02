package com.example.geektrust.service.impl;

import com.example.geektrust.model.Course;
import com.example.geektrust.service.ICommandService;
import com.example.geektrust.util.Constant;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CancelCourse implements ICommandService {
    @Override
    public void execute(TreeMap<String, Course> courseMap, Map<String, Course> registeredEmployeeCourseMap, List<String> parameteres) throws Exception {
        if (parameteres.size() != Constant.CANCEL_COURSE_PARAMETER_SIZE) {
            throw new Exception("INVALID_INPUT_ERROR");
        }
        String employeeRegistrationId = parameteres.get(0);
        if (registeredEmployeeCourseMap.get(employeeRegistrationId) != null) {
            if (registeredEmployeeCourseMap.get(employeeRegistrationId).isAlloted()) {
                System.out.println(employeeRegistrationId + " " + Constant.CANCEL_REJECTED);
            } else {
                Course course = registeredEmployeeCourseMap.get(employeeRegistrationId);
                course.getRegisteredEmployees().remove(employeeRegistrationId);
                registeredEmployeeCourseMap.remove(employeeRegistrationId);
                System.out.println(employeeRegistrationId + " " + Constant.CANCEL_ACCEPTED);
            }
        } else {
            System.out.println(employeeRegistrationId + " " + Constant.CANCEL_REJECTED);
        }
    }
}
