package bankpackage;

import java.util.Iterator;

public class Main {
    public static void main(String[] args){

Bank ahly=new Bank("ahly"); //make a bank object
ATM atm111=ahly.createATM(111);//make and ATM object with the Bank
Customer muhamed=ahly.addNewCustomer("muhamed",1,012,1,20,1,6763);//making a customer
Customer ahmed=ahly.addNewCustomer("ahmed",2,0122,2,70,2,6555);//making a second customer
ahly.addBankAccToCustomer(3,100,1,3,5555);//adding a bank account and card to the first customer

        muhamed.makeTransaction(40,"deposit",1,6763,atm111); //customer muhamed making a deposit
        ahmed.makeTransaction(50,"withdrawal",2,6555,atm111);//cutomer ahmed making a withdrawal

        Iterator<BankAccount> ahmedAccs=ahmed.getAllBankAccounts().iterator();//print ahmed's bank accounts and cards and each account with transaction history
        System.out.println(ahmedAccs.next()+"\n");

        Iterator<BankAccount> muhamedAccs=muhamed.getAllBankAccounts().iterator();//print muhamed's bank accounts and cards and each account with transaction history
        System.out.println(muhamedAccs.next()+"\n");
        System.out.println(muhamedAccs.next());

//in case when making a customer with duplicate card NO or Acc NO or Customer ID NO... you'll be asked to enter new data (not very practical but just to show the feature)
       Customer mahmoud= ahly.addNewCustomer("mahmoud",3,0122,4,120,4,6666);
        System.out.println(muhamed);



    }
}
