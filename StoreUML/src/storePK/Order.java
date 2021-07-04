package storePK;

import java.util.ArrayList;

public class Order {
    private String shipingDetails;
    private Buyer buyer;
    private  Seller seller;
    private float shipingCost;
    private ArrayList<Item> items;
    private float itemsCost;

    public Order(String shipingDetails, Buyer buyer, Seller seller, ArrayList<Item> items,float itemsCost) {
        this.shipingDetails = shipingDetails;
        this.buyer = buyer;
        this.seller = seller;
        this.shipingCost = Integer.parseInt(shipingDetails)*15;
        this.items = items;
        this.itemsCost=itemsCost;
    }


    public float getShipingCost() {
        return shipingCost;
    }

    @Override
    public String toString() {
        return "Order{" +
                "shipingDetails='" + shipingDetails + '\'' +
                ", buyer=" + buyer +
                ", seller=" + seller +
                ", shipingCost=" + shipingCost +
                ", items=" + items +
                ", itemsCost=" + itemsCost +
                '}'+"\n";
    }
}
