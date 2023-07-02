package com.example.geektrust.model;

public class Employee {
    String name;

    public String getName() {
        return name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    String emailAddress;

    public Employee(String name, String emailAddress) throws Exception {
        if (emailAddress.indexOf("@") > 0) {
            this.name = emailAddress.substring(0, emailAddress.indexOf("@"));
        } else
            throw new Exception("INVALID_DATA_INPUT");
        this.emailAddress = emailAddress;
    }


}
