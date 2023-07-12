import java.time.LocalDate;
import java.time.LocalTime;

public class Account {

    public Account(String name, String address, int age, int i) {
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", balance=" + balance +
                ", age=" + age +
                ", account_number=" + account_number +
                '}';
    }

    private String name;
    private  String address;
    private double balance;
    private int age;
    private  int account_number=1000000;
    private static int no_of_accounts=0;
    private int pin;

    public Account(){
        System.out.println();
    };

    public Account(int pin,String name, String address,int age,double balance) {
        this.pin=pin;
        this.name = name;
        this.address = address;
        this.balance = balance;
        this.age = age;
        no_of_accounts++;
        account_number+=no_of_accounts;

    }

    public int getAccount_number() {
        return account_number;
    }
    public int getPin() {return pin;}
    public static int getNo_of_accounts() {
        return no_of_accounts;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public double getBalance() {return balance;}
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    //==================================================================================================================
    void Mybalance(){
        System.out.println("Your current balance is: RS "+getBalance());
    }
    void deposit(double amount){
        LocalDate date= LocalDate.now();
        LocalTime time=LocalTime.now();
        setBalance(getBalance()+amount);
        System.out.println("transaction succesfull.");
        System.out.println("RS "+amount+" deposited to your account at "+time+" on "+date+" from the Bandarawela branch.");
    }

     void withdraw(double amount){
        if(getBalance()<amount){
            System.out.println("transaction incompleted.");
            System.out.println("Your account balance is insuffucient.");
            return;}
        LocalDate date= LocalDate.now();
        LocalTime time=LocalTime.now();
        setBalance(getBalance()-amount);
        System.out.println("transaction successfull.");
        System.out.println("RS "+amount+" withdraw from your account at "+time+" on "+date+" from the Bandarawela branch.");
    }

    void transfer(Account a,double amount){
        if(getBalance()<amount){
            System.out.println("transaction incompleted.");
            System.out.println("Your account balance is insuffucient.");
            return;}
        LocalDate date= LocalDate.now();
        LocalTime time=LocalTime.now();
        setBalance(getBalance()-amount);
        a.setBalance(a.getBalance()+amount);
        System.out.println("transaction succesfull.");
        System.out.println("RS "+amount+" trasfer to the account number "+"("+a.account_number+")."+"at "+time+" on "+date+" from the Bandarawela1 branch.");
    }

    public void User(){
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("Enter corresponding number.");
        System.out.println(" 1) To check balance\n 2) To deposit\n " +
                "3) To withdraw\n 4) To transfer\n 5) To get account details\n" +
                " 6) Exit");
        System.out.println("----------------------------------------------------------------------------------------------");

    }


}


