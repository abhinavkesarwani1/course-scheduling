package com.example.geektrust.service;

import com.example.geektrust.service.impl.AddCourse;
import com.example.geektrust.service.impl.Allot;
import com.example.geektrust.service.impl.CancelCourse;
import com.example.geektrust.service.impl.Register;
import com.example.geektrust.util.Constant;

public class CommandServiceExecutor {

    public ICommandService getCommandExecutor(String command) {
        if (command.equalsIgnoreCase(Constant.ADDCOURSEOFFERING)) {
            return new AddCourse();
        } else if (command.equalsIgnoreCase(Constant.REGISTER)) {
            return new Register();
        } else if (command.equalsIgnoreCase(Constant.ALLOT)) {
            return new Allot();
        } else if (command.equalsIgnoreCase(Constant.CANCEL)) {
            return new CancelCourse();
        }
        return null;
    }
}
