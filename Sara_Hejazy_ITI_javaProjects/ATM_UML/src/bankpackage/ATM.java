package bankpackage;

public class ATM {
    public int ATMNo;
    Bank bank;
    String bankName;

    public ATM() {
    }

    public ATM(int ATMNo,Bank bank) {
        this.ATMNo = ATMNo;
        this.bank = bank;
        this.bankName = bank.getBankName();
    }
    private boolean VerifyCard(Card card,int customerPinCode){
        return customerPinCode==card.getPinNo();}


    private BankAccount cardReader(Card card){
        return card.getCardBankAccount();
    }
    public void processTransacion(String type,float amount,Card card,int customerPinCode) {
        if (this.VerifyCard(card, customerPinCode)) {
            BankAccount acc = this.cardReader(card);
            Transaction transaction = new Transaction(amount, type, acc,this);
            if (type == "withdrawal") {
                transaction.withdraw();
            } else if (type == "deposit") {
                transaction.deposit();
            }
            acc.addTransactionsRecord(transaction);
        }
        else{
            System.out.println("Wrong Pincode");
        }
    }
}
