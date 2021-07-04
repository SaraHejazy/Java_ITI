import joinery.DataFrame;
import org.apache.poi.ss.formula.functions.Column;
import org.knowm.xchart.*;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

class DF{
    public static DataFrame readCsv(String path){
        DataFrame df=null;
        try {
            df=DataFrame.readCsv(path);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return df;}

        public static DataFrame groubing(DataFrame df,String f1){

        return df.sortBy(f1).groupBy(a->List.class.cast(a).get(0));

        }
        public static DataFrame putBackIndex(DataFrame ndf,String colName){
            List<String> co=new ArrayList<>();
            co.addAll(ndf.index());
            ndf.add(colName,co);
            ndf=ndf.resetIndex();
            return ndf;
        }

        public static void plotCategoryChart(DataFrame df,String cf, String nf,int n,Boolean top){
            CategoryChart c=new CategoryChartBuilder().width(1024).height(1024).yAxisTitle(cf).yAxisTitle(nf).build();
            if (n<1){n=df.length();}
        if(top){
            c.addSeries("Publisher to global sales",df.sortBy(nf).tail(n).col(cf),df.sortBy(nf).tail(n).col(nf));
        }
        else{
            c.addSeries("Publisher to global sales",df.sortBy(nf).head(n).col(cf),df.sortBy(nf).head(n).col(nf));
        }
            new SwingWrapper(c).displayChart();

        }
        public static void plotPieChart(DataFrame df,String cf, String nf,int n,Boolean top){
            PieChart pc =new PieChartBuilder().width(1024).height(1024).build();
            if (n<1){n=df.length();}
            if(top){
            for(int i=0;i<n;i++){
                pc.addSeries((String)df.sortBy(nf).tail(n).col(cf).get(i),(Double) df.sortBy(nf).tail(n).col(nf).get(i));}}
            else{
                for(int i=0;i<n;i++){
                    pc.addSeries((String)df.sortBy(nf).head(n).col(cf).get(i),(Double) df.sortBy(nf).head(n).col(nf).get(i));}
            }
            new SwingWrapper(pc).displayChart();
        }

    }



public class JDB {
    public static void main(String[] args) {

        DataFrame df = DF.readCsv("vgsales.csv");

        DataFrame ndf =DF.groubing(df.retain("Publisher","Global_Sales"),"Publisher").sum().apply(value->Number.class.cast(value).doubleValue());//groups by publishers and gets sum of global sales for all there games

        ndf=DF.putBackIndex(ndf,"Publisher");
        System.out.println(ndf);
        DF.plotCategoryChart(ndf,"Publisher","Global_Sales",10,true); //category chart for top n publishers and global sales n=10
        DF.plotPieChart(ndf,"Publisher","Global_Sales",0,true);//pie chart for top n publishers and global sales if n=0 then it displays all publishers

        //System.out.println(df.retain("Publisher").unique(0).sortBy("Publisher").col("Publisher"));//



        System.out.println(df.select(a->(List.class.cast(a).get(3).equals("N/A"))?false:Integer.parseInt((String) List.class.cast(a).get(3))>2000));//display under condition year >2000

        System.out.println(df.select(a->(List.class.cast(a).get(5).equals("Nintendo"))?true:false));//display all data for publisher Nintendo

//                    new DataFrame.Predicate<>() {
//                                             @Override
//                                             public Boolean apply(List<Object> o) {
//
//
//                                                        return ((o.get(3).equals("N/A"))?false:Long.parseLong((String)o.get(3))>2000);
//
//
//                                             }
//                                         }
//            ));



    }
}
