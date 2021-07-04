package bankpackage;

public class Transaction {

    private float amount;
    private String transactionType;
    private BankAccount bankAcc;
    private int atmNo;

    public Transaction(float amount,  String transactionType, BankAccount bankAcc,ATM atm) {
        if (amount>0){
        this.amount = amount;}
        else {this.amount=0;}

        this.transactionType = transactionType;
        this.bankAcc = bankAcc;
        this.atmNo= atm.ATMNo;
    }

    public String getTransactionInfo() {
        String info="{Transaction type: " +this.transactionType+
                " from Account No: "+
                this.bankAcc.getBankAccNo()+" amount: "+this.amount+
                " ATM No: "+this.atmNo+"}";

        return info;
    }

    public void withdraw(){

        if ((bankAcc.getCreditAmount()-this.amount)>=0){
            bankAcc.setCreditAmount(bankAcc.getCreditAmount()-this.amount);}
        else{
            System.out.println("Insufficent Credit");
        }
    }

    public void deposit(){

        bankAcc.setCreditAmount(bankAcc.getCreditAmount()+this.amount);
    }


    @Override
    public String toString() {
        return this.getTransactionInfo();
    }
}
