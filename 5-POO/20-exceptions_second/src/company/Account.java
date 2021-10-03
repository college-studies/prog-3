package company;

// unchecked exception
class handleDepositException extends RuntimeException {
    private double value;

    //constructor
    public handleDepositException(String str, double value) {
        super(str);
        this.value = value;
    }

    // getter
    public double getValue() {
        return this.value;
    }
}


public class Account {
    private double balance;

    // constructor
    public Account() {this.balance = 0.0;}
    public double getBalance () {return this.balance;}

    // make a deposit
    public void deposit(double value) {
        if (value < 0) {
            throw new handleDepositException("Negative deposit value", value); // throw exception
        } else {
            this.balance +=value;
        }
    }

    // withdraw money from account
    public void withdraw(double value) {
        if (this.balance < value) {
            throw new IllegalArgumentException("Balance value is less than withdraw asked");
        } else {
            this.balance -= value;
        }
    }
}