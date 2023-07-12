import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;



public class Main {

    public static void Interface(){
        LocalDate date= LocalDate.now();
        LocalTime time=LocalTime.now();
        System.out.println("--------------------------------------------------------------------------------------------" +
                "-------------------------------------------------");
        System.out.println("Welcome to our bank.\nYou logged into our bank at "+time+" on "+ date+".");
        System.out.println("--------------------------------------------------------------------------------------------" +
                "-------------------------------------------------");
    }

    public static void main(String[] args) {
        HashMap<Integer,Account> hashMap=new HashMap<>();
        Account account1=new Account(1234,"sithum","wee",21,1000);
        Account account2=new Account(2345,"koshal","asd",18,500);
        Account account3=new Account(4567,"nimanthi","ghj",47,4000);
        Account account4=new Account(5678,"jayatathna","yui",50,10000);
        Account account5=new Account(6789,"nilu","zse",30,500);
        Account account6=new Account(7890,"sadu","jrs",22,100);
        hashMap.put(account1.getPin(),account1);
        hashMap.put(account2.getPin(),account2);
        hashMap.put(account3.getPin(),account3);
        hashMap.put(account4.getPin(),account4);
        hashMap.put(account5.getPin(),account5);
        hashMap.put(account6.getPin(),account6);

        //==============================================================================================================
        HashMap<Integer,Account> hashMapTransfer=new HashMap<>();
        hashMapTransfer.put(account1.getAccount_number(),account1);
        hashMapTransfer.put(account2.getAccount_number(),account2);
        hashMapTransfer.put(account3.getAccount_number(),account3);
        hashMapTransfer.put(account4.getAccount_number(),account4);
        hashMapTransfer.put(account5.getAccount_number(),account5);
        hashMapTransfer.put(account6.getAccount_number(),account6);

        int num=0;
        while(num==0) {

            Interface();
            Scanner scanner = new Scanner(System.in);
            int attemp = 0, left = 3, pin_number = 0;
            boolean correct = false;


            while (attemp < 3 && correct == false) {
                System.out.print("Enter your Pin_number : ");
                pin_number = scanner.nextInt();
                attemp++;
                left--;
                try {
                    if (hashMap.containsKey(pin_number)) {
                        correct = true;
                    } else {
                        System.out.println("\nplease Enter a valid pin number.\nYou have " + left + " attemps left.try again\n");
                        System.out.println("----------------------------------------------------------------------------------------------");

                    }
                } catch (Exception e) {
                    System.out.println("\nplease Enter a valid pin number.\nYou have " + left + " attemps left.try again\n");
                    System.out.println("----------------------------------------------------------------------------------------------");
                }
            }

            if (correct == true) {
                Account account = hashMap.get(pin_number);
                int UserInput = 0;
                while (UserInput != 6) {
                    account.User();
                    System.out.print("Enter: ");
                    UserInput = scanner.nextInt();
                    switch (UserInput) {
                        case 1: {
                            account.Mybalance();
                            break;
                        }
                        case 2: {
                            double amount;
                            System.out.println("Enter deposit amount: ");
                            amount = scanner.nextInt();
                            account.deposit(amount);
                            break;
                        }

                        case 3: {
                            double amount;
                            System.out.println("Enter withdraw amount: ");
                            amount = scanner.nextInt();
                            account.withdraw(amount);
                            break;
                        }
                        case 4: {
                            double amount;
                            int accnum;
                            System.out.println("Enter transfer amount: ");
                            amount = scanner.nextInt();
                            System.out.println("Enter account number of the other account ");
                            accnum = scanner.nextInt();
                            Account now = hashMapTransfer.get(accnum);
                            account.transfer(now, amount);break;
                        }
                        case 5: {
                            System.out.println(account);
                            break;
                        }
                        case 6: {
                            System.out.println("Thank you for engage with us.Have a good day.");
                            break;
                        }
                    }
                }

            } else {
                System.out.println("Your account has blocked.");
            }
            System.out.println("\n\n\n\n");
        }



    }
}

