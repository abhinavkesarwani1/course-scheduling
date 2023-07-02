package com.example.geektrust;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try {
            CourseScheduling courseScheduling = CourseScheduling.getInstance();
            File myObj = new File(args[0]);
            //File myObj = new File("sample_input/input1.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data[] = myReader.nextLine().split(" ");
                courseScheduling.executeCommand(data[0], Arrays.asList(data).subList(1,data.length));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}