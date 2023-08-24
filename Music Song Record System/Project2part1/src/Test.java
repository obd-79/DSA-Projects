import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {
    static RecordSystem recordSystem = new RecordSystem();
    static Scanner obd = new Scanner(System.in);
    public static void main(String[] args) throws FileNotFoundException {
        recordSystem.ReadFile("project.txt");
        boolean quit = false;
        while (!quit){
            System.out.println("--------------------------");
            printMenu();
            int action = obd.nextInt();
            obd.nextLine();
            switch (action) {
                case 0:
                    System.out.println("C U soon...");
                    quit = true;
                break;
            case 1 : addSong();
                break;

                case 2 :deleteSong();
                    break;

                case 3: SearchWithId();
                    break;

                case 4 : SearchWithName();
                    break;

                case 5 : printAllSong();
                    break;

                case 6 : SearchBetweenRange();
                    break;

                case 7 :Display();
                    break;

            }

        }
    }
    public static void printMenu(){
        System.out.println("Available actions:\npress");
        System.out.println("0 - to quit\n" +
                "1 - to Add Song\n" +
                "2 - to Delete Songs\n" +
                "3 - to search with Id\n" +
                "4 - to search with Name\n" +
                "5 - to print all Songs\n" +
                "6 - search between Ranges\n" +
                "7 - Display all the music of specific type");
    }
    public static void addSong(){
        System.out.println("Enter the Song Name : ");
       String SongName = obd.nextLine();
        System.out.println("Enter the Artist : ");
       String Artist = obd.nextLine();
        System.out.println("Enter the Genre : ");
       String genre = obd.nextLine();
        System.out.println("Enter the Year : ");
        String year = obd.nextLine();
        System.out.println("Enter the Id : ");
      String  id = obd.nextLine();
        if (recordSystem.addSong( SongName ,Artist ,  genre ,  year ,  id)){
            System.out.println("Song has been added");
        }
        else {
            System.out.println("The song is already in the list");
        }
    }
    public static void deleteSong(){
        System.out.println("Enter the id : ");
       String
               id = obd.nextLine();
        if (recordSystem.DeleteWithId(id)){
            System.out.println("the song is deleted");
        }
        else {
            System.out.println("the song is not in the list (Id not found)");
        }
    }
    public static void SearchWithId(){
        System.out.println("Enter the id : ");
        String Id = obd.nextLine();
       if (recordSystem.SearchWithID(Id)!= null){
           Singer s = recordSystem.SearchWithID(Id);
           System.out.println("The song is founded : ");
           System.out.print(s.SongName + ";" + s.Artist + ";" + s.id + ";" + s.genre + ";" + s.year);
           System.out.println();
       }
        System.out.println("the song is not found");
    }
    public static void SearchWithName(){
        System.out.println("Enter the Name : ");
       String name = obd.nextLine();
        if (recordSystem.SearchWithName(name)!= null){
            Singer s = recordSystem.SearchWithName(name);
            System.out.println("The song is founded : ");
            System.out.print(s.SongName + ";" + s.Artist + ";" + s.id + ";" + s.genre + ";" + s.year);
            System.out.println();

        }
        else {
            System.out.println("the song is not found");
        }
    }
    public static void printAllSong(){
        recordSystem.print();
    }
    public static void SearchBetweenRange(){
        System.out.println("Enter the Id1 : ");
       int ID1 = obd.nextInt();
        if (recordSystem.SearchWithID(Integer.toString(ID1))== null){
            System.out.println("The id is not found");
        }
        else {
            System.out.println("Enter the Id2 : ");
           int ID2 = obd.nextInt();
            if (recordSystem.SearchWithID(Integer.toString(ID2))== null){
                System.out.println("The id is not found");
            }
            else {
                System.out.println("The songs Are : ");
                recordSystem.printRanges(ID1 , ID2);
            }
        }

    }
    public static void Display(){
        System.out.println("Enter the Genre : ");
      String  Genre = obd.nextLine();
        if (recordSystem.SearchForGenre(Genre)){
            System.out.println("the songs are : ");
            recordSystem.printAllGenre(Genre);
        }
        else {
            System.out.println("this genre is not in the list");
        }
    }

}
