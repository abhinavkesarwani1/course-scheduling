package com.example.geektrust.service;

import com.example.geektrust.model.Course;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public interface ICommandService {
    void execute (TreeMap<String, Course> courseMap, Map<String, Course> registeredEmployeeCourseMap,
                  List<String> parameteres) throws Exception;
}
