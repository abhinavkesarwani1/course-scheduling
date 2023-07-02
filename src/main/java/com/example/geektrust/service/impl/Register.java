package com.example.geektrust.service.impl;

import com.example.geektrust.model.Course;
import com.example.geektrust.model.Employee;
import com.example.geektrust.service.ICommandService;
import com.example.geektrust.util.Constant;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Register implements ICommandService {
    @Override
    public void execute(TreeMap<String, Course> courseMap, Map<String, Course> registeredEmployeeCourseMap, List<String> parameteres) throws Exception {
        if (parameteres.size() != Constant.REGISTER_PARAMETER_SIZE) {
            throw new Exception("INPUT_DATA_ERROR");
        }
        String employeeEmail = parameteres.get(0);
        String courseName = parameteres.get(1);
        try {
            if (courseMap.containsKey(courseName)) {
                Course course = courseMap.get(courseName);
                if (course.getRegisteredEmployees().size() >= course.getMaxCapacity()) {
                    throw new Exception("COURSE_FULL_ERROR");
                } else {
                    Employee employee = new Employee(employeeEmail, employeeEmail);
                    String registrationId = course.addEmployee(employee);
                    registeredEmployeeCourseMap.put(registrationId, course);
                    System.out.println(registrationId + " ACCEPTED");
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
