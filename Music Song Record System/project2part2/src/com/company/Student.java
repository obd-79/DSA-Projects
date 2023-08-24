package com.company;
import java.util.LinkedList;

public class Student {
     String name;
    LinkedList<Integer> numberOfTxt;
    public Student(String name) {
        this.name = name;
        numberOfTxt = new LinkedList<>();
    }
}
