package bankpackage;

import java.util.ArrayList;
import java.util.Scanner;

public class Bank {


    String bankName;
    private ArrayList<Customer> allCustomers;
    private ArrayList<BankAccount> bankAccounts;
    private ArrayList<ATM> allATMs;
    private ArrayList<Integer> allBankAccNo;
    private ArrayList<Integer> allCustomerIDNo;
    private ArrayList<Integer> allCardNo;

    public Bank(String name) {
        this.bankName=name;
        this.allCustomers =new ArrayList<>();
        this.bankAccounts =new ArrayList<>();
        this.allATMs=new ArrayList<>();
        this.allBankAccNo =new ArrayList<>();
        this.allCustomerIDNo =new ArrayList<>();
        this.allCardNo =new ArrayList<>();

    }

    public String getBankName() {
        return bankName;
    }



    public ATM createATM(int ATMNo){
        ATM atm=new ATM(ATMNo,this);
        this.allATMs.add(atm);
        return atm;
    }

    public Customer addNewCustomer(String name, int customerID, int contactInfo,int bankAccNo, float creditAmount,int cardNo,int cardPinNo) {
        customerID=this.verifyIDNo(customerID);
        Customer customer=new Customer(name,customerID,contactInfo,this.getBankName()); //make customer
        this.addIDNo(customer);

        bankAccNo=this.verifyAccNo(bankAccNo);
        BankAccount acc=new BankAccount(bankAccNo,customer,creditAmount); // make acc  for the customer
        this.addAccNo(acc);

        cardNo=this.verifyCardNo(cardNo);
        Card card=new Card(cardNo,customer,cardPinNo,acc); //make card for acc and customer
        this.addCardNo(card);

        this.allCustomers.add(customer); //add customer to bank customers list
        acc.addCard(card); // add card to acc card list
        customer.addBankAcc(acc); // add acc to customer's acc list
        customer.addCard(card); // add card to customer card list

        return customer;
    }
    public void addBankAccToCustomer(int bankAccNo, float creditAmount,int customerID,int cardNo,int cardPinNo){
        boolean isCustomerFound=false;
        for(Customer customer:allCustomers){
            if (customer.getCustomerID()==customerID){
                bankAccNo=this.verifyAccNo(bankAccNo);
                BankAccount acc=new BankAccount(bankAccNo,customer,creditAmount);
                this.addAccNo(acc);

                cardNo=this.verifyCardNo(cardNo);
                Card card=new Card(cardNo,customer,cardPinNo,acc);
                this.addCardNo(card);

                acc.addCard(card); // add card to acc card list
                customer.addBankAcc(acc); // add acc to customer's acc list
                customer.addCard(card); // add card to customer card list
            isCustomerFound=true;
            }
        }
        if(isCustomerFound){}
        else{System.out.println("no Customer with this ID");}

}
public void addAccNo(BankAccount acc){
        this.allBankAccNo.add(acc.getBankAccNo());

}
public boolean isAccNoUnique(int accNo){
        for(int i:this.allBankAccNo){
            if(i==accNo){
                return false;
            }
        }
        return true;
    }
    public int verifyAccNo(int bankAccNo){
        while (true){
            if(this.isAccNoUnique(bankAccNo)){

                break;}
            else{
                System.out.println("Bank Account No already exist");
                System.out.println("enter another Bank Account No: ");
                Scanner sc=new Scanner(System.in);
                bankAccNo= sc.nextInt();
            }}
        return bankAccNo;
    }
    public void addIDNo(Customer customer){
        this.allCustomerIDNo.add(customer.getCustomerID());

    }
    public boolean isIDNoUnique(int IDNo){
        for(int i:this.allCustomerIDNo){
            if(i==IDNo){
                return false;
            }
        }
        return true;
    }
    public int verifyIDNo(int IDNo){
        while (true){
            if(this.isIDNoUnique(IDNo)){

                break;}
            else{
                System.out.println("Customer ID No already exist");
                System.out.println("enter another Customer ID No: ");
                Scanner sc=new Scanner(System.in);
                IDNo= sc.nextInt();
            }}
        return IDNo;
    }

    public void addCardNo(Card card){
        this.allCardNo.add(card.getCardNo());

    }
    public boolean isCardNoUnique(int cardNo){
        for(int i:this.allCardNo){
            if(i==cardNo){
                return false;
            }
        }
        return true;
    }
    public int verifyCardNo(int cardNo){
        while (true){
            if(this.isCardNoUnique(cardNo)){

                break;}
            else{
                System.out.println("Card No already exist");
                System.out.println("enter another Card No: ");
                Scanner sc=new Scanner(System.in);
                cardNo= sc.nextInt();
            }}
        return cardNo;
    }

}