package PK;

public class Country {
    public String name;
    public int code;


    public Country(String[] arr) {
        this.name = arr[0];
        this.code = Integer.parseInt(arr[1]);

    }
}
