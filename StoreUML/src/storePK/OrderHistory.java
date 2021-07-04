package storePK;

import java.util.ArrayList;

public class OrderHistory {
    private ArrayList<Order> ordersList;
    public OrderHistory(ArrayList<Order> ordersList) {
        this.ordersList = ordersList;
    }

    public void addOrder(Order order){
        this.ordersList.add(order);
    }

    @Override
    public String toString() {
        return "OrderHistory{" +
                 ordersList +
                '}';
    }
}
