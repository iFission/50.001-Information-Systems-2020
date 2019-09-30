public class CheckingAccount extends Account {

    public CheckingAccount() {
    }

    public CheckingAccount(int id, double balance) {
        super(id, balance);
    }

    @Override
    public void withdraw(double amount) {
        double leftover = this.getBalance() - amount;

        if (leftover < -5000) {
            System.out.println("over limit");
        } else {
            super.withdraw(amount);
        }
    }
}
