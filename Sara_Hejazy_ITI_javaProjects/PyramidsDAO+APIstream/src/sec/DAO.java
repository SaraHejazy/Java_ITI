package sec;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DAO {
    public static ArrayList<Pyramid> readCSV(String path) {
        ArrayList<Pyramid> pyramids=new ArrayList<Pyramid>();
        try{
        BufferedReader br = new BufferedReader(new FileReader(path));

        String lines= br.readLine();
        if (lines!=null){
            lines= br.readLine();
        }
        while(lines!=null){
            String[] attrib= lines.split(",");
            pyramids.add(new Pyramid(attrib));
            lines= br.readLine();
        }

        }
        catch (Exception e){}
        return pyramids;
    }
}
