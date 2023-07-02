package com.example.geektrust.model;

import java.util.*;

public class Course {
    private final String courseId;
    private final String courseName;
    private final String instructor;
    private final Date date;
    private final int minCapacity;

    private final int maxCapacity;
    private boolean isAlloted;

    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getInstructor() {
        return instructor;
    }

    public Date getDate() {
        return date;
    }

    public int getMinCapacity() {
        return minCapacity;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public boolean isAlloted() {
        return isAlloted;
    }

    public boolean isCancelled() {
        return isCancelled;
    }

    public Map<String, Employee> getRegisteredEmployees() {
        return registeredEmployees;
    }

    public void setAlloted(boolean alloted) {
        isAlloted = alloted;
    }

    public void setCancelled(boolean cancelled) {
        isCancelled = cancelled;
    }

    private boolean isCancelled;

    private final Map<String, Employee> registeredEmployees;

    public Course() {
        this.courseId = "";
        this.courseName = "";
        this.instructor = "";
        this.date = new Date();
        this.minCapacity = 0;
        this.maxCapacity = 0;
        this.registeredEmployees = new TreeMap<>();
    }
//    public Course(String courseId, String courseName, String instructor, Date date, int minCapacity, int maxCapacity) {
//        this.courseId = courseId;
//        this.courseName = courseName;
//        this.instructor = instructor;
//        this.date = date;
//        this.minCapacity = minCapacity;
//        this.maxCapacity = maxCapacity;
//        this.isAlloted = false;
//        this.isCancelled = false;
//        this.registeredEmployees = new TreeMap<>();
//    }

    public String addEmployee(Employee emp) {
        String registrationId = "REG-COURSE-" + emp.getName() + "-" + this.courseName;
        registeredEmployees.put(registrationId, emp);
        return registrationId;
    }


}
