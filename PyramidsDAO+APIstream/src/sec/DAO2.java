package sec;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class DAO2 {

    public ArrayList<Pyramid> readCSV(String path){
        ArrayList<Pyramid> pyramidss=new ArrayList<Pyramid>();
        try{
            Scanner sc = new Scanner(new File(path));
            String lines=sc.nextLine();
            if (lines!=null){
                lines= sc.nextLine();
            }
            while (lines!=null){
                String[] atrrib=lines.split(",");
                pyramidss.add(new Pyramid(atrrib));
                lines=sc.nextLine();
            }
        }
        catch (Exception e){}
        return pyramidss;
    }
}
