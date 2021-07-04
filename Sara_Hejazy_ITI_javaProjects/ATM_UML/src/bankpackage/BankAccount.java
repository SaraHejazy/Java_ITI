package bankpackage;

import java.util.ArrayList;

public class BankAccount {
    private int bankAccNo;
    private Customer customer;
    int customerID;
    private float creditAmount;
    private ArrayList<Transaction> transactionsRecord;
    private ArrayList<Card> cardsConnected;

    public BankAccount(int bankAccNo,Customer customer, float creditAmount){
        this.bankAccNo=bankAccNo;
        this.customer=customer;
        this.creditAmount=creditAmount;
        this.customerID=customer.getCustomerID();
        this.cardsConnected=new ArrayList<>();
        this.transactionsRecord=new ArrayList<>();
    }
    public BankAccount(){
        this.cardsConnected=new ArrayList<>();
        this.transactionsRecord=new ArrayList<>();
    }






    public void addCard(Card card) {
        this.cardsConnected.add(card);
    }

    public int getBankAccNo() {
        return bankAccNo;
    }


    public float getCreditAmount() {
        return creditAmount;
    }

    public ArrayList<Transaction> getTransactionsRecord() {
        return transactionsRecord;
    }

    public ArrayList<Card> getCardsConnected() {
        return cardsConnected;
    }

    public void setCreditAmount(float creditAmount) {
        this.creditAmount = creditAmount;
    }
    public void addTransactionsRecord(Transaction transaction) {
        this.transactionsRecord.add(transaction) ;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "bankAccNo=" + bankAccNo +
                ", customerID=" + customerID +
                ", creditAmount=" + creditAmount +"\n"+
                ", cardsConnected=" + cardsConnected +"\n"+
                ", transaction records: "+transactionsRecord+
                "}\n";
    }
}

