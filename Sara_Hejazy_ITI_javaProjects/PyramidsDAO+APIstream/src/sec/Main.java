package sec;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        String path="pyramids.csv";

        DAO d = new DAO();

        ArrayList<Pyramid> pyramids=d.readCSV(path);
        //System.out.println(pyramids);

        ArrayList<Pyramid> sortedPyramids;
        sortedPyramids=pyramids.stream().filter(pyramid -> pyramid.getBase1()!=0).sorted((s1,s2)->s1.getBase1().compareTo(s2.getBase1())).collect(Collectors.toCollection(ArrayList::new));
        System.out.println(sortedPyramids);
        Pyramid medianPyramidByBase1;
        medianPyramidByBase1=pyramids.stream().filter(pyramid -> pyramid.getBase1()!=0).sorted(Comparator.comparing(Pyramid::getBase1)).collect(Collectors.toCollection(ArrayList::new)).get((pyramids.size())/2-1);
        Pyramid lowerQuartilePyramidByBase1;
        lowerQuartilePyramidByBase1=pyramids.stream().filter(pyramid -> pyramid.getBase1()!=0).sorted(Comparator.comparing(Pyramid::getBase1)).collect(Collectors.toCollection(ArrayList::new)).get(pyramids.size()/4);
        Pyramid upperQuartilePyramidByBase1;
        upperQuartilePyramidByBase1=pyramids.stream().filter(pyramid -> pyramid.getBase1()!=0).sorted(Comparator.comparing(Pyramid::getBase1)).collect(Collectors.toCollection(ArrayList::new)).get(pyramids.size()*3/4);

        System.out.println("Lower quartile pyramid: "+lowerQuartilePyramidByBase1);
        System.out.println("median Pyramid: "+medianPyramidByBase1);
        System.out.println("Lower quartile pyramid: "+upperQuartilePyramidByBase1);

        double avg=sortedPyramids.stream().mapToDouble(pyramid->pyramid.getBase1()).average().orElseThrow(Exception::new);
        System.out.println("average value of Base 1 is "+avg+"m");


    }
}
