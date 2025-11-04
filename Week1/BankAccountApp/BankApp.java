
public class BankApp {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("123456", "Alice", 1000.0);
        System.out.println("Account Owner: " + account.getOwner());
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Initial Balance: $" + account.getBalance());   
        account.deposit(500.0);
        System.out.println("Balance after deposit: $" + account.getBalance());
        boolean success = account.withdraw(200.0);
        if (success) {
            System.out.println("Balance after withdrawal: $" + account.getBalance());
        }
        account.withdraw(2000.0);
        System.out.println("Balance after attempted overdraw: $" + account.getBalance());
        
    }
}
