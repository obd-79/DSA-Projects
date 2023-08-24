package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    static LinearProbingHashTable chainedHashtable = new LinearProbingHashTable(40);
    static Scanner obd = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {
        readFile("1.txt", 1);
        readFile("2.txt", 2);
        readFile("3.txt", 3);
        readFile("4.txt", 4);
        readFile("5.txt", 5);
        readFile("6.txt", 6);
        readFile("7.txt", 7);
        readFile("8.txt", 8);
        readFile("9.txt", 9);
        readFile("10.txt", 10);


        System.out.println("-----------------");
        System.out.println("Enter the name: ");
        String name = obd.next();
        Search(name);

    }

    public static void readFile(String nameOfTheFile, int numberOFTxt) throws FileNotFoundException {
        File f = new File(nameOfTheFile);
        Scanner file = new Scanner(f);
        while (file.hasNext()) {
            String data = file.next();
            String[] array = data.split(" ");
            String name = array[0];
            Student student = new Student(name);
            chainedHashtable.insert(name, student, numberOFTxt);
        }
    }

    public static void Search(String name) {

        Student student = chainedHashtable.search(name.toLowerCase(Locale.ROOT));
        if (student != null) {
            System.out.println("This word has been appeared in the following files: " + student.numberOfTxt + ".txt");
        } else
            System.out.println("No text file includes");

    }
}