import java.util.Random;

public class BankAccount {
    private String fname , lname , city , address;
    private static long uniqueAccountNo=1900555500001000L;
    private  long accountNo;
    private int pinCode;
    private double balance;
    private String pan;

//Constructor to initialize the variables and necessary data .
    BankAccount(String fname , String lname , String address , String city , String pan , int pinCode , double balance){
        this.fname = fname;
        this.lname = lname;
        this.address =address;
        this.city =city;
        this.pan = pan;
        this.pinCode = pinCode;
        this.balance = balance;
        this.accountNo = setAccountNo();
    }

    //Method to generate random and unique account number.
    public long setAccountNo(){
        Random random = new Random();
         accountNo = uniqueAccountNo +(random.nextInt(1000,5000));
         return accountNo;
    }

    //Method to deposit amount .
    public boolean deposit(double amount){
        if(amount >0){
            this.balance +=amount;
            return true;
        }
        return false;
    }

    //Method to withdraw amount .
    public boolean withDraw(double amount){
        if(this.balance>0 && this.balance >=amount){
            this.balance -= amount;
            return true;
        }
        return false;
    }

    // Transfer money to another account
    public boolean transfer(BankAccount recipient, double amount) {
        if (amount > 0 && amount <= balance) {
            if (this.withDraw(amount)) {
                recipient.deposit(amount);
                return true;
            }
        }
        return false;
    }

    //Method to check balance
    public double checkBalance(){
        return balance;
    }

    //Method to display the bank account details
    public void displayAccountDetails(){
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("---------------Account Details---------------");
        System.out.println("Account Number : "+accountNo);
        System.out.println("First Name : "+fname +"\t"+"Last Name : "+lname);
        System.out.println("Address : "+address);
        System.out.println("City : "+city);
        System.out.println("Pincode : "+pinCode);
        System.out.println("Pan Number : "+pan);
        System.out.println("----------------------------------------------------------------------------");
    }


}
