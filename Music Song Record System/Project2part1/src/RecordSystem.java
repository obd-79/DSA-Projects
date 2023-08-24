
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class RecordSystem {
    ArrayList<Singer>singers;
    TreeMap<String , Integer> Names;
    TreeMap<String , Integer> Artists;
    TreeMap<String , Integer> IDs;
    TreeMap<String , Integer> Genre;
    TreeMap<String , Integer> year;
    int index ;

    public RecordSystem() {
        singers = new ArrayList<Singer>();
        Names = new TreeMap<>();
        Artists = new TreeMap<>();
        IDs = new TreeMap<>();
        Genre = new TreeMap<>();
        year = new TreeMap<>();
        index = 0;
    }

    public void ReadFile(String nameOfFile) throws FileNotFoundException {
        File f = new File(nameOfFile);
        Scanner file = new Scanner(f);
        String name = "";
        String artists ="";
        String id = "";
        String genre = "";
        String year = "";
        while (file.hasNext()){
            String data = file.next();
            String[] array = data.split(";");
            name = array[0];
            artists = array[1];
            id =array[2];
            genre= array[3];
            year = array[4];
            singers.add(new Singer(name , artists , genre , year , id));
            Names.put(name , index);
            Artists.put(artists , index);
            IDs.put(id , index);
            Genre.put(genre , index);
            this.year.put(year , index);
            index++;
        }
    }
    public Singer SearchWithID(String id){
        if (IDs.containsKey(id)){
            int num = IDs.get(id);
            return singers.get(num);
        }
        return null;
    }
    public Singer SearchWithName(String name){
        if (Names.containsKey(name)) {
            int num = Names.get(name);
            return singers.get(num);
        }
        return null;
    }
    public void print(){
        for (int i =  0 ;i < singers.size() ; i++){
            Singer s = singers.get(i);
            System.out.print(s.SongName + ";" + s.Artist + ";" + s.id + ";" + s.genre + ";" + s.year);
            System.out.println();
        }
    }
    public boolean SearchForGenre(String genre){
        return this.Genre.containsKey(genre);
    }
    public void printAllGenre(String genre){
            System.out.println("the songs name of " + genre + " :");
            for (Singer ss : singers) {
                if (ss.genre.equals(genre)) {
                    System.out.println(ss.SongName);

                }
            }


    }
    public void printRanges(int ID1 , int ID2 ){
        for (int i = ID1 ; i <= ID2 ; i ++){
            Singer s = SearchWithID(Integer.toString(i));
            System.out.print(s.SongName + ";" + s.Artist + ";" + s.id + ";" + s.genre + ";" + s.year);
            System.out.println();
        }
    }


    public boolean addSong(String SongName, String Artist , String genre , String year , String id ){
        if (SearchWithID(id) == null) {
            singers.add(new Singer(SongName, Artist, genre, year, id));
            Names.put(SongName, index);
            Artists.put(Artist, index);
            IDs.put(id, index);
            Genre.put(genre, index);
            this.year.put(year, index);
            index++;
            return true;

        }
        return false;

        }



    public boolean DeleteWithId(String id){
       Singer songWillDeleted = SearchWithID(id);
        if (songWillDeleted!= null){
            IDs.remove(id);
            Names.remove(songWillDeleted.SongName);
            Artists.remove(songWillDeleted.Artist);
            Genre.remove(songWillDeleted.genre);
            this.year.remove(songWillDeleted.year);
            singers.remove(songWillDeleted);
            return true;

        }
        return false;
    }


}