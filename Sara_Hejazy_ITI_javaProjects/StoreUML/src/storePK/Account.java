package storePK;

import java.util.ArrayList;
import java.util.Arrays;

public class Account {
    String[] loginCredin ;
    ArrayList<String> paymentMethods;

    public Account(String userID,String password) {
        this.loginCredin = new String[]{userID, password};
        this.paymentMethods = new ArrayList<>();
    }
    public void addPaymentMethod(String paymentMethod){
        this.paymentMethods.add(paymentMethod);
    }

    public String[] getLoginCredin() {
        return loginCredin;
    }


}
