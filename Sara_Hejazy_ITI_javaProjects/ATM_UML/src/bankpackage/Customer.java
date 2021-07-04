package bankpackage;

import java.util.ArrayList;

public class Customer {

    private String name;
    private int customerID;
    private int contactInfo;
    private ArrayList<Card> cards;
    private ArrayList<BankAccount> bankAccounts;
    private int pinNo;
    private Bank bank;


    public Customer(String name, int customerID, int contactInfo,String bankName) {
        this.name = name;
        this.cards= new ArrayList<>();
        this.bankAccounts=new ArrayList<>();
        this.customerID = customerID;
        this.contactInfo = contactInfo;
        this.bank=new Bank(bankName);
    }

    public void addCard(Card card){
        this.cards.add(card);
    }

    public void addBankAcc(BankAccount bankAcc) {
        this.bankAccounts.add(bankAcc);
    }


    public String getName() {
        return name;
    }

    public int getCustomerID() {
        return customerID;
    }

    public int getContactInfo() {
        return contactInfo;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public ArrayList<BankAccount> getAllBankAccounts() {
        return bankAccounts;
    }

    public Card getSpecificCard(int cardNo){
        Card card=new Card();
        for(Card myCard :this.getCards()){
            if (myCard.getCardNo()==cardNo){
                card=myCard;
            }
        }
      return card;
    }


    public int writePinCode(){
        return pinNo;
}

    public void makeTransaction(float transactionAmount,String transactionType,int cardNo,int pinCode,ATM atm){
        Card card=this.getSpecificCard(cardNo);
        if(card.getCardNo()==0){
            System.out.println("no card with this No");}
        else {
            atm.processTransacion(transactionType, transactionAmount, card, pinCode);
        }
    }

    @Override
    public String toString() {
        return "Customer{" +
                "\n-name='\n" + name + '\'' +
                "\n, -customerID=\n" + customerID +
                "\n, -cards=\n" + cards +
                "\n, -bankAccounts=\n" + bankAccounts +
                "\n, -bank=\n" + bank.getBankName() +
                '}';
    }
}
