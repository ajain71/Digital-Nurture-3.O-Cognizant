class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public synchronized void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + ", New Balance: " + balance);
    }

    public synchronized void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrew: " + amount + ", New Balance: " + balance);
        } else {
            System.out.println("Insufficient balance to withdraw " + amount + ", Current Balance: " + balance);
        }
    }

    public double getBalance() {
        return balance;
    }
}

public class BankAccountSimulation {

    static class Transaction extends Thread {
        private BankAccount account;
        private boolean deposit;
        private double amount;

        public Transaction(BankAccount account, boolean deposit, double amount) {
            this.account = account;
            this.deposit = deposit;
            this.amount = amount;
        }

        @Override
        public void run() {
            if (deposit) {
                account.deposit(amount);
            } else {
                account.withdraw(amount);
            }
        }
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.00);

        Transaction t1 = new Transaction(account, true, 200.00); // Deposit
        Transaction t2 = new Transaction(account, false, 150.00); // Withdraw
        Transaction t3 = new Transaction(account, false, 300.00); // Withdraw
        Transaction t4 = new Transaction(account, true, 400.00); // Deposit

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Balance: " + account.getBalance());
    }
}
