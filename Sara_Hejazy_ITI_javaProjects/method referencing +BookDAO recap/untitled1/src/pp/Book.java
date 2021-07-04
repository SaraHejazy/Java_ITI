package pp;

public class Book {
    public Book(String[] a) {
        this.name = a[0];
        this.price = Integer.parseInt(a[1]);
        this.auther = a[2];
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", auther='" + auther + '\'' +
                '}';
    }

    String name;
    Integer price;
    String auther;


}
