import java.util.Date;

// ATTENTION 
// just edit this file
// TestAccount.java contains the test cases provided in the problem set 
// Put in any import statements that you need 

public class Account {

    private int id = 0;
    private double balance = 0;
    private double annualInterestRate = 0;
    private Date dateCreated;

    public Account() {
    }

    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public int getID() {
        return this.id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return this.annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public double getMonthlyInterestRate() {
        return this.annualInterestRate / 12;
    }

    public double getMonthlyInterest() {
        return getMonthlyInterestRate() * this.balance / 100;
    }

    public void withdraw(double amount) {
        this.balance -= amount;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

}