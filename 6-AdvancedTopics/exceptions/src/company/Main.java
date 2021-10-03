package company;

public class Main {
    public static void main(String[] args) {
        Account account = new Account();

        account.deposit(100);
        System.out.println("Balance after deposit: " + account.getBalance());

        // exception wont be thrown
        try {
            account.deposit(50);
        } catch (IllegalArgumentException e) {
            System.out.println("Withdraw failed" + e.getMessage());
        }

        // exception will be thrown
        try {
            account.deposit(-35);
        } catch (handleDepositException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Balance after withdraw: " + account.getBalance());
    }
}
