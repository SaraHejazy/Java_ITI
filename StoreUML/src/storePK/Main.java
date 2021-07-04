package storePK;

public class Main {
    public static void main(String[] args) {
        Store amazon =new Store("Amazon");
        Buyer ahmed =amazon.makeBuyer("ahmed11","123","1");//store makes a customer account
        Seller muhamed = amazon.makeSeller("muhamed11","111");//store makes a seller account
        amazon.addItems("toy1",100,"good toy"); // store adding items to the store
        amazon.addItems("toy2",150,"very good toy");
        amazon.addItems("toy3",10,"not so good toy");
        System.out.println("Store Items are "+amazon.getItems());

        ahmed.shopping(amazon,muhamed);//goes through the store and choose items to buy or add to wishlist where seller process the order


        System.out.println(ahmed.getOrderHistory());
        System.out.println("wishList is"+ahmed.getWishList());

        ahmed.exploreWishList(muhamed);//goes through wishlist and decide weather to add something to the cart to buy or leave it or delete it from list
        
        System.out.println(ahmed.getOrderHistory());
        System.out.println("wishList is"+ahmed.getWishList());
    }
}
