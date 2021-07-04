import org.knowm.xchart.*;
import tech.tablesaw.api.*;
import tech.tablesaw.selection.Selection;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public class LoadingData {
    public static void main(String[] args) {

        Table hr = null;
        try {
            hr = Table.read().csv("dataMay-5-2021.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
            System.out.println("table summary \n"+hr.summary());
            System.out.println("\n table shape \n"+hr.shape());
            int rowcount= hr.rowCount();

            List<Double> salary=new ArrayList<>();
            for(int i=0;i<rowcount;i++){
                salary.add(i*100.0);
            }
            DoubleColumn fakeSalary=DoubleColumn.create("fake",salary);//making a column
            hr.addColumns(fakeSalary);//adding a column to the table
            System.out.println("\ncheck added column with name: fake \n"+hr.summary());

            Table sf=hr.select("name","close").sortOn("close");
            System.out.println("\n table with where clause \n"+sf.where(sf.numberColumn("close").isGreaterThan(200)));//where clause to show only "closes" bigger than 200

            Selection sc=hr.categoricalColumn("name").asStringColumn().containsString("Amena");//selection statement on catigorical column
            System.out.println("\n where clause to only show row with name Amena \n"+hr.where(sc));
            int rownum=20;
            hr=hr.sortOn("close");

            List<Integer> closes=((IntColumn)hr.column("close")).last(rownum).asList();
            List<String> names=((StringColumn) hr.column("name")).last(rownum).asList();
            CategoryChart chart=new CategoryChartBuilder().width(1024).height(600).xAxisTitle("Names").yAxisTitle("Closes").build();
            chart.addSeries("name to closes",names,closes);
            new SwingWrapper(chart).displayChart();//categorcal chart of the top 5 in close column with name
            PieChart pc =new PieChartBuilder().width(1024).height(1024).build();
            for(int i=0;i<names.size();i++){
            pc.addSeries(names.get(i), closes.get(i));}

        new SwingWrapper(pc).displayChart();//pie chart of the top 5 in close column with name


    }
}
