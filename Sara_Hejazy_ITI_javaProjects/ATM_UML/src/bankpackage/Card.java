package bankpackage;

import java.util.ArrayList;
import java.util.Arrays;

public class Card {
    private int cardNo;
    private Customer customer;
    private String customerName;
    private int pinNo;
    private BankAccount cardBankAccount;

    public Card(int cardNo, Customer customer, int pinNo, BankAccount cardBankAccount) {
        this.cardNo = cardNo;
        this.customer = customer;
        this.customerName= customer.getName();
        this.pinNo = pinNo;
        this.cardBankAccount = cardBankAccount;
    }

    public Card() {}



    public int getCardNo() {
        return cardNo;
    }



    public int getPinNo() {
        return pinNo;
    }

    public BankAccount getCardBankAccount() {
        return cardBankAccount;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardNo=" + cardNo +
                ", customerName='" + customerName + '\'' +
                ", cardBankAccountNO=" + cardBankAccount.getBankAccNo() +
                '}';
    }
}
