package pp;

import java.util.ArrayList;
import java.util.stream.Collectors;

@FunctionalInterface
interface Check{
    public String check(int n);
}

@FunctionalInterface
interface Extreme {
    public int getn(ArrayList<Integer> arr);

}
public class Main {
    public static void main(String[] args) {
        Check even =Ref::evenCheck;
        System.out.println(even.check(0));
        Check positive=Ref::positiveCheck;
        System.out.println(positive.check(0));

        ArrayList<Integer> arr=new ArrayList<>();
                arr.add(0);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        Extreme maximum =MaxMin::maxi;
        System.out.println("maximum element is "+maximum.getn(arr));

        Extreme minimum =MaxMin::mini;
        System.out.println("minimum element is "+minimum.getn(arr));


        String path ="Book.csv";
        ArrayList<Book> books=DAO.readCSV(path);
        System.out.println(books);
        ArrayList<Book> above40Books=books.stream().filter(book->book.price>40).collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Book> sortedBooks=books.stream().sorted((s1,s2)-> s1.auther.compareTo(s2.auther)).collect(Collectors.toCollection(ArrayList::new));
        System.out.println(sortedBooks);
        System.out.println(above40Books);

    }
}
