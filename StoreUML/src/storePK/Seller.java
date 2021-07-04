package storePK;

import java.util.ArrayList;
import java.util.Iterator;

public class Seller extends User {
    ArrayList<Item> soldItems;
    private Store store;

    public Seller(Account account,Store store) {
        super(account);
        this.store=store;

        this.soldItems = new ArrayList<Item>();

    }
    public void processCart(Buyer buyer){
        float totalPrice=0;
        //buyer.shopping(this.store);
        Iterator<Item> it= buyer.getCart().iterator();
        if (it.hasNext()){
        for (Item item :buyer.getCart()){
            totalPrice+=item.getPrice();
        }
        Order order =new Order(buyer.getShipingDetails(),buyer,this, buyer.getCart(),totalPrice);
            System.out.println(totalPrice+order.getShipingCost());
        buyer.getOrderHistory().addOrder(order);
        buyer.setCart(new ArrayList<>());}

    }

    @Override
    public String toString() {
        return "Seller{" +
                "SellerID=" + account.getLoginCredin()[0] +
                '}';
    }
}
