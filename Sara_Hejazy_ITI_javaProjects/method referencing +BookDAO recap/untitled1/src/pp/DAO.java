package pp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class DAO {
    public static ArrayList<Book> readCSV(String path){
        ArrayList<Book> books=new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            System.out.println("22");
            String lines= br.readLine();
            if (lines!=null){
                lines= br.readLine();
            }
            while(lines!=null){
                String[] attrib=lines.split(",");
                books.add(new Book(attrib));
                lines= br.readLine();
            }
        }
        catch (Exception e){}
    return books;
    }

}
