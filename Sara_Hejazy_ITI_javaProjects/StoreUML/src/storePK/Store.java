package storePK;

import java.util.ArrayList;

public class Store {
    public String name;
    private ArrayList<Buyer> buyers;
    private ArrayList<Seller> sellers;
    private ArrayList<Item> items;
    private ArrayList<Order> orders;

    public Store(String name) {
        this.name = name;
        this.buyers = new ArrayList<>();
        this.sellers = new ArrayList<>();
        this.items = new ArrayList<>();
        this.orders = new ArrayList<>();
    }

    public Buyer makeBuyer(String buyerID,String buyerAccPasswd,String shipingDetails){
        Account account=new Account(buyerID,buyerAccPasswd);
        Buyer buyer=new Buyer(account,shipingDetails,new OrderHistory(new ArrayList<>()));
        this.buyers.add(buyer);
        return buyer;
    }
    public Seller makeSeller(String sellerID,String sellerAccPasswd) {
        Account account = new Account(sellerID, sellerAccPasswd);
        Seller seller = new Seller(account,this);
        this.sellers.add(seller);
        return seller;
    }

    public void addItems(String name,float price,String description){
        this.items.add(new Item(name, price, description));
    }

    public ArrayList<Item> getItems() {
        return items;
    }


}
