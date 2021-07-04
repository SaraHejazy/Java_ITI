package PK;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class Places {
    public static ArrayList<City> readCity(String path) {

        ArrayList<City> city=new ArrayList<>();
    try {
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line=br.readLine();
        if(line!=null){
            line= br.readLine();
        }
        while(line!=null){
            String[] atrib=line.split(",");
            city.add(new City(atrib));
            line=br.readLine();
        }

    }catch (Exception e){}

     return city;
    }

    public static ArrayList<Country> readCountry(String path) {

        ArrayList<Country> country=new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line=br.readLine();
            if(line!=null){
                line= br.readLine();
            }
            while(line!=null){
                String[] atrib=line.split(",");
                country.add(new Country(atrib));
                line=br.readLine();
            }

        }catch (Exception e){}

        return country;
    }
    public static Map<Integer,ArrayList<City>> cityClassifier(String cityPath,String countryPath){

        ArrayList<City> cityList = Places.readCity(cityPath);
        Iterator<City> cityIt;

        ArrayList<Country> countryList = Places.readCountry(countryPath);
        Iterator<Country> countryIt=countryList.iterator();

        Map<Integer,ArrayList<City>>map=new HashMap<>();

        while(countryIt.hasNext()){
            int countryCode=countryIt.next().code;
            cityIt=cityList.iterator();
            while(cityIt.hasNext()){
                City city=cityIt.next();
                if(city.code==countryCode){
                    if(map.get(countryCode)!=null){
                        map.get(countryCode).add(city);

                    }
                    else{
                        ArrayList<City> cities=new ArrayList<>();
                        cities.add(city);
                        map.put(countryCode,cities);
                    }

                }
            }
        }
        map.forEach((k,v)-> Collections.sort(v));
        return map;
    }
    }



