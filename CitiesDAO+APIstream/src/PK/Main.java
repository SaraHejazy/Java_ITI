package PK;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String cityPath="citys.csv";
        String countryPath="countries.csv";

        System.out.println("cities grouped by country sorted by population without stream API:\n"+Places.cityClassifier(cityPath,countryPath)+"\n");
        ArrayList<Country> countries =Places.readCountry(countryPath);
        ArrayList<City> cities =Places.readCity(cityPath);

        Map<Integer,ArrayList<City>> countryCity;
        countryCity =new HashMap<>();

        Map<Integer, City> maxPopulationByCountry;
        maxPopulationByCountry=new HashMap<>();

        Map<String, City> maxPopulationByContinent;
        maxPopulationByContinent=new HashMap<>();

        Map<String,ArrayList<City>> continentCity =new HashMap<>();
        Set<String> continents=new HashSet<>();

        cities.stream().forEach(city -> continents.add(city.continent));

        countries.stream().forEach(country -> countryCity.put(country.code, cities.stream().filter(city -> city.code==country.code).sorted(Comparator.comparing(City::getPopulation)).collect(Collectors.toCollection(ArrayList::new))));
        continents.stream().forEach(continent -> continentCity.put(continent, cities.stream().filter(city -> city.continent.equals(continent)).sorted(Comparator.comparing(City::getPopulation)).collect(Collectors.toCollection(ArrayList::new))));
        continents.stream().forEach(continent -> maxPopulationByContinent.put(continent, cities.stream().filter(city -> city.continent.equals(continent)).max(Comparator.comparing(City::getPopulation)).get()));



                countries.stream().forEach(country ->maxPopulationByCountry.put(country.code, cities.stream().filter(city -> city.code==country.code).max(Comparator.comparing(City::getPopulation)).get()));



        System.out.println("Cities grouped by Countries sorted by Population:\n"+countryCity+"\n");
        System.out.println("city with highest population in each country:\n"+maxPopulationByCountry+"\n");
        System.out.println("Cities grouped by Continents sorted by Population:\n"+continentCity+"\n");
        System.out.println("city with highest population in each continent:\n"+maxPopulationByContinent+"\n");
    }
}
