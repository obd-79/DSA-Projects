package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;
public class Main {
   static Graph graph;
   static Scanner obd = new Scanner(System.in);

    static {
        try {
            graph = readFile("got-edges.csv");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("------Welcome To Game Of Thrones Networking-----");
        printMenu();
        int option;
        boolean flag = true;
        while (flag){
            System.out.println();
            System.out.println("Choose An Option : ");
             option = obd.nextInt();
            switch (option){
                case 0 :
                    printMenu();
                    break;
                case 1 :
                    System.out.println("Enter the source");
                    String source= obd.next();
                    System.out.println("Enter the target");
                    String target = obd.next();
                    System.out.println("Enter the weight");
                    int weight = obd.nextInt();
                    Add(source , target , weight);
                    break;
                case 2:
                    System.out.println("Enter the character");
                    String character = obd.next();
                    System.out.println("Enter the Threshold");
                    int threshold = obd.nextInt();
                    printFartherCharacter(character , threshold);
                    break;
                case 3 :
                    System.out.println("Enter the character");
                    String ss = obd.next();
                    System.out.println("Enter the Threshold");
                    int s = obd.nextInt();
                    printClosestCharacter(ss , s);
                    break;
                case 4 :
                    System.out.println("Enter the Character number 1");
                    String Character1 = obd.next();
                    System.out.println("Enter the Character number 2");
                    String Character2 = obd.next();
                    checkConnected(Character1 , Character2);
                    break;
                case 5 :
                    System.out.println("Enter the Source");
                    String so = obd.next();
                    System.out.println("Enter the target");
                    String q = obd.next();
                    Delete(so , q);
                    break;
                case 6 :
                    System.out.println("Enter the source");
                    String source1 = obd.next();
                    System.out.println("Enter the target");
                    String target2 = obd.next();
                    System.out.println("Enter the weight");
                    int ww = obd.nextInt();
                    change(source1 , target2 , ww);
                    break;
                case 7 :
                    printTheCharacter();
                    break;
                case 8 :
                    System.out.println("Enter the Source");
                    String sour = obd.next();
                    printBFS(sour);
                    break;
                case 9 :
                    flag = false;

            }

        }
    }
    public static Graph readFile(String fileName) throws FileNotFoundException {
        File f = new File (fileName);
        Scanner file = new Scanner(f);
        String source = "";
        String target = "";
        int weight = 0;
        file.nextLine();
        Graph graph = new Graph(353);
        while (file.hasNext()){
            String data = file.nextLine();
            String[] array = data.split(",");
            source = array[0];
            target = array[1];
            weight =Integer.parseInt(array[2]);
            graph.addEgde(source.toLowerCase(Locale.ROOT) , target.toLowerCase(Locale.ROOT) , weight);
        }
        return graph;
    }
    public static void printMenu(){
        System.out.println("""
                0-printMenu
                1-Add An Edge
                2-Print Farther Character
                3-Print Closest Character
                4-Check If It Connected
                5-Delete An Edge
                6-Change An Edge
                7-Print The Characters
                8-Print With BFS
                9-Quit""");
    }
    public static void Add(String source , String target , int weight){
        graph.addEgde(source , target , weight);
    }
    public static void printFartherCharacter(String character , int threshold){
        graph.printFartherCharacter(character , threshold);
    }
    public static void printClosestCharacter(String character , int threshold){
        graph.printClosetCharacter(character , threshold);
    }
    public static void checkConnected(String character, String character2){
        if (graph.isConnected(character , character2)){
            System.out.println("yes it is connected");
        }
        else {
            System.out.println("No it is not connected");
        }
    }
    public static void Delete(String source , String target){
      if (graph.delete(source , target)){
          System.out.println("Its deleted");
      }
      else {
          System.out.println("The Character not found in the list");
      }
    }
    public static void change(String source , String target , int weight){
        if (graph.change(source  , target , weight)){
            System.out.println("it is done");
        }
        else {
            System.out.println("The Character not found in the list");
        }
    }
    public static void printTheCharacter(){
        graph.NumberOfCharacterGroups();
    }
    public static void printBFS(String source){
        graph.PrintWithBFS(source);
    }

}
