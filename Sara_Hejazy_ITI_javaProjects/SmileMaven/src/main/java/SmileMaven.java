import org.apache.commons.csv.CSVFormat;
import smile.data.DataFrame;
import smile.data.Tuple;
import smile.data.measure.NominalScale;
import smile.data.type.DataType;
import smile.data.type.DataTypes;
import smile.data.type.StructField;
import smile.data.type.StructType;
import smile.data.vector.BaseVector;
import smile.data.vector.IntVector;
import smile.io.Read;
import smile.plot.swing.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.time.Year;
import java.util.*;
import java.util.stream.Collectors;

class DF {

    public static DataFrame readCsv(String path) {
        CSVFormat format=CSVFormat.DEFAULT.withFirstRecordAsHeader();
        DataFrame df = null;

        try {
            df= Read.csv(path,format);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return df;
    }
    public static double[] getSalesSum(DataFrame df,String f1,String nf2,int n){
        String[] publishers= df.stringVector(f1).distinct().toArray(new String[]{});
        HashMap<Object,Double> map1=new HashMap<>();
        Arrays.stream(publishers).forEach(p->map1.put(p,0.0));
        df.select(f1,nf2).stream().collect(Collectors.groupingBy(row -> row.getString(f1))).forEach((k,v)->v.stream().forEach(t->map1.put(k,map1.get(k)+(Double)t.get(nf2))));

        int m=publishers.length;
        double[] sales= new double[m];
        for(int i=0;i< m;i++){
            sales[i]=map1.get(publishers[i]);

        }
        sales= Arrays.stream(sales).sorted().toArray();
        double[] topSales=Arrays.copyOfRange(sales,m-n,m);

        return  topSales;
    }
    public static int[] grouping(DataFrame df,String f1,int n){
        String[] publishers= df.stringVector(f1).distinct().toArray(new String[n]);
        NominalScale ns=new NominalScale(publishers);
        int[] arr=df.stringVector(f1).factorize(ns).toIntArray();
        int[] darr= Arrays.stream(arr).distinct().toArray();
        int[]sortedarr= new int[darr.length];
        for(int i:arr){
            sortedarr[i]+=1;
        }

        sortedarr= Arrays.stream(sortedarr).sorted().toArray();
        int[] slicedarr=Arrays.copyOfRange(sortedarr,sortedarr.length-n-1,sortedarr.length);

    return slicedarr;}

    public static void plotBarPlot(int[] arr,String f1,String f2){
        Canvas can =BarPlot.of(arr).canvas().setTitle(f1).setAxisLabel(0,f2);
        try {
            can.window();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }}
    public static void plotBarPlot(double[] arr,String f1,String f2){
        Canvas can =BarPlot.of(arr).canvas().setTitle(f1).setAxisLabel(0,f2);
        try {
            can.window();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }}

    public static void plotHistogam(int[] arr,String f1){
        Canvas can =Histogram.of(arr).canvas().setTitle(f1);
        try {
            can.window();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    public static void plotHistogam(double[] arr,String f1){
        Canvas can =Histogram.of(arr).canvas().setTitle(f1);
        try {
            can.window();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }


        }


public class SmileMaven {
    public static void main(String[] args) {
        String f1="Publisher";
        String f2="Global_Sales";
        DataFrame df =DF.readCsv("vgsales.csv");
        //DF.plotBarPlot(DF.getSalesSum(df,f1,f2,20),f2+" of top "+20+" Publishers",f1);
        //DF.plotBarPlot(DF.grouping(df,f1,20),"Number of Games",f1);

        String[] publishers= df.stringVector(f1).distinct().toArray(new String[]{});
        HashMap<Object,Double> map1=new HashMap<>();
        Arrays.stream(publishers).forEach(p->map1.put(p,0.0));
        df.select(f1,f2).stream().collect(Collectors.groupingBy(row -> row.getString(f1))).forEach((k,v)->v.stream().forEach(t->map1.put(k,map1.get(k)+(Double)t.get(f2))));



        StructField[] scc =new StructField[]{new StructField("publisher",DataTypes.StringType),new StructField("Global_Sales",DataTypes.FloatType) };
        StructType stt= new StructType(scc);
        Object[] oo=new Object[]{"Nintendo",20.0};
        Tuple t =Tuple.of(oo,stt);
        System.out.println(t);







        int n=map1.size();
        List<Tuple> tl = new ArrayList<>();
        StructField[] sc = new StructField[2];
        sc[0]=new StructField("publisher", DataTypes.StringType);
        sc[1]=new StructField("Global_Sales",DataTypes.IntegerType);
        StructType st=new StructType(sc);
        System.out.println(map1);

        Object[] a=new Object[n];
        System.out.println(a.length);
        for (int i=0;i< n;i++){

            Object k=map1.keySet().toArray()[i];
            tl.add(Tuple.of(new Object[]{k,(int)((double)map1.get(k))},st));

        }
        DataFrame dd=DataFrame.of(tl.stream().sorted(Comparator.comparingInt(b->(int)( b.get("Global_Sales")))).collect(Collectors.toList()));
        dd=dd.slice(dd.size()-10,dd.size());
        System.out.println(dd);
        df=DataFrame.of(df.stream().filter(s->!s.get("Year").equals("N/A")).collect(Collectors.toList()));
        Object[] years=df.select("Year").stream().filter(s->!s.get("Year").equals("N/A")).toArray();
        //System.out.println(Arrays.toString(years));
        List<Tuple> yearst=new ArrayList<>();
        //Arrays.stream(years).forEach(s->yearst.add(Tuple.of(new Object[]{s,new StructType(new StructField[]{new StructField("Yearss", DataTypes.IntegerObjectType)})))};
        //DataFrame dy=DataFrame.of(yearst);
        //System.out.println(yearst);
        //df.merge(DataFrame.of(yearst));
        //System.out.println(df);
        Object oop = 12.2;
        System.out.println((int)((double)oop));
        System.out.println(Arrays.toString(Arrays.asList(1,2,3).stream().toArray()));
    }
}
