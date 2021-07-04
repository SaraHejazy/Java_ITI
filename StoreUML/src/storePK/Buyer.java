package storePK;

import java.util.ArrayList;
import java.util.Scanner;

public class Buyer extends User{
    private ArrayList<Item> cart;
    private ArrayList<Item> wishList;
    private OrderHistory orderHistory;
    private String shipingDetails;


    public Buyer(Account account,String shipingDetails,OrderHistory orderHistory) {
        super(account);
        this.cart = new ArrayList<Item>();
        this.wishList = new ArrayList<Item>();
        this.shipingDetails=shipingDetails;
        this.orderHistory=orderHistory;
    }

    public ArrayList<Item> getCart() {
        return cart;
    }

    public ArrayList<Item> getWishList() {
        return wishList;
    }

    public void setWishList(ArrayList<Item> wishList) {
        this.wishList = wishList;
    }

    public OrderHistory getOrderHistory() {
        return orderHistory;
    }

    public void setCart(ArrayList<Item> cart) {
        this.cart = cart;
    }

    public String getShipingDetails() {
        return this.shipingDetails;
    }

    public void shopping(Store store,Seller seller){
        Scanner sc =new Scanner(System.in);
        String like;
        for(Item item:store.getItems()) {
            System.out.println(item + "\nenter c to add to cart ,,, w to add to wishList ,,, or n to ignore or ..q to quit");
            like = sc.nextLine();
            if (like.equals("c")) {
                this.addToCart(item);
            } else if (like.equals("w")) {
                this.addToWishList(item);
            }
            else if (like.equals("q")){
                break;
            }
        }
            seller.processCart(this);

    }

    public void addToCart(Item item){
            this.cart.add(item);


        }

    public void addToWishList(Item item) {
        this.wishList.add(item);
    }
    public void exploreWishList(Seller seller){
        Scanner sc =new Scanner(System.in);
        String like;
        ArrayList<Item> remainingItems=new ArrayList<>();
        for(Item item:this.getWishList()) {
            System.out.println(item + "\nenter c to add to cart ,,, w to keep in wishList ,,, or n to remove from wish list");
            like = sc.nextLine();
            if (like.equals("c")) {
                this.addToCart(item);

            } else if (like.equals("w")) {
                remainingItems.add(item);
            }
        }
        this.setWishList(remainingItems);
        seller.processCart(this);

    }



    public void setShipingDetails(String shipingDetails) {
        this.shipingDetails = shipingDetails;
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "BuyerID=" + account.getLoginCredin()[0] +
                '}';
    }
}
