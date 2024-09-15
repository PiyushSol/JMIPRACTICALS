import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("Welcome to Bank of India");
        Scanner scanner = new Scanner(System.in);
        String fname , lname , address , city,pan;
        int pinCode;
        double balance,depositAmount,withdrawlAmount;
        BankAccount B=null , recipientAccount =null;
        char ch;
        do{
            System.out.println("Choose any of the options .");
            System.out.println("1. Create new Bank Account\n"+"2. Deposit Money\n"+"3. Withdraw Money\n"+"4. Transfer Money\n"+"5. Check Current Balance\n"+"6. Display Account Details");
            System.out.println("Enter Q to quit.");
            System.out.println("Enter your choice");
            ch = scanner.next().charAt(0);
            switch (ch){
                case '1':
                    scanner.nextLine();
                    System.out.println("Enter your First name : ");
                    fname=scanner.nextLine();
                    System.out.println("Enter your Last name : ");
                    lname=scanner.nextLine();
                    System.out.println("Enter your Address : ");
                    address= scanner.nextLine();
                    System.out.println("Enter your City : ");
                    city = scanner.nextLine();
                    System.out.println("Enter your Pincode : ");
                    pinCode = scanner.nextInt();
                    System.out.println("Enter your Pan Details : ");
                    pan = scanner.next();
                    System.out.println("Enter your balance : ₹ ");
                    balance = scanner.nextDouble();
                    B = new BankAccount(fname,lname,address,city,pan,pinCode,balance);
                    System.out.println("Congratulations!! Account Created Successfully.");
                    break;
                case '2':
                    if(B != null){
                        System.out.println("Enter the money to deposit : ₹");
                        depositAmount = scanner.nextDouble();
                        if(B.deposit(depositAmount)){
                            System.out.println("Money Deposited Successfully : ₹ "+depositAmount);
                        }
                        else {
                            System.out.println("Invalid deposit amount.");
                        }
                    }
                    else {
                        System.out.println("No account found. Please create an account first.");
                    }
                    break;
                case '3':
                    if (B != null) {
                        System.out.print("Enter the amount to withdraw: ₹ ");
                         withdrawlAmount = scanner.nextDouble();
                        if (B.withDraw(withdrawlAmount)) {
                            System.out.println("Withdrew: ₹ " + withdrawlAmount);
                        } else {
                            System.out.println("Invalid withdrawal amount or insufficient balance.");
                        }
                    } else {
                        System.out.println("No account found. Please create an account first.");
                    }
                    break;
                case '4':
                    if (B != null) {
                        if (recipientAccount == null) {
                            System.out.println("Recipient account not initialized. Creating a default recipient account.");
                            recipientAccount = new BankAccount("Raj", "Kumar", "11 Hudson Lane", "New Delhi", "XYZ123456", 654321, 5000.00);
                        }

                        System.out.print("Enter the amount to transfer: ₹");
                        double transferAmount = scanner.nextDouble();
                        scanner.nextLine();
                        if (B.transfer(recipientAccount, transferAmount)) {
                            System.out.println("Transferred: ₹" + transferAmount + " to recipient account.");
                        } else {
                            System.out.println("Insufficient balance or invalid transfer amount.");
                        }
                    } else {
                        System.out.println("No account found. Please create an account first.");
                    }
                    break;
                case '5':
                    if(B!=null){
                        double curr_Balance = B.checkBalance();
                        System.out.println("Current Balance is : ₹ "+curr_Balance);
                    }else {
                        System.out.println("No account found. Please create an account first.");
                    }
                    break;
                case '6':
                    if (B != null) {
                        B.displayAccountDetails();
                    } else {
                        System.out.println("No account found. Please create an account first.");
                    }
                    break;

                case 'Q':
                case 'q':
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        }while(ch!='Q' && ch!='q');

    }
}
