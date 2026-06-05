package part3.task3_2;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Objects;

public class BankAccount {
    private final String accountNumber;
    private double balance;
    private final String owner;
    private int failedAttempts;
    private boolean blocked;
    private String pin;

    private static final int MAX_FAILED_ATTEMPTS = 3;
    private static final double EPS = 1e-9;

    public BankAccount(String accountNumber, String owner, double initialBalance, String pin) {
        Objects.requireNonNull(accountNumber, "accountNumber must not be null");
        Objects.requireNonNull(owner, "owner must not be null");
        Objects.requireNonNull(pin, "pin must not be null");
        if (initialBalance < 0) throw new IllegalArgumentException("initialBalance must be >= 0");
        if (pin.isEmpty()) throw new IllegalArgumentException("pin must not be empty");

        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = initialBalance;
        this.pin = pin;
        this.failedAttempts = 0;
        this.blocked = false;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getOwner() {
        return owner;
    }

    public int getFailedAttempts() {
        return failedAttempts;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public boolean validatePin(String pin) {
        return this.pin != null && this.pin.equals(pin);
    }

    public synchronized boolean withdraw(String enteredPin, double amount) {
        if (blocked) {
            return false;
        }
        if (!validatePin(enteredPin)) {
            failedAttempts++;
            if (failedAttempts >= MAX_FAILED_ATTEMPTS) {
                blocked = true;
            }
            return false;
        }

        failedAttempts = 0;

        if (amount <= 0.0 || Double.isNaN(amount) || Double.isInfinite(amount)) {
            return false;
        }

        if (balance + EPS >= amount) {
            balance -= amount;
            if (Math.abs(balance) < EPS) balance = 0.0;
            return true;
        } else {
            return false;
        }
    }

    public synchronized boolean deposit(double amount) {
        if (amount <= 0.0 || Double.isNaN(amount) || Double.isInfinite(amount)) {
            return false;
        }
        balance += amount;
        return true;
    }

    public String getMaskedBalance() {
        if (balance > 100_000.0) {
            return "СКРЫТО";
        } else {
            DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
            DecimalFormat df = new DecimalFormat("#,##0.00", symbols);
            return df.format(balance);
        }
    }

    public synchronized void blockAccount() {
        this.blocked = true;
    }

    public synchronized void unblockAccount() {
        this.blocked = false;
        this.failedAttempts = 0;
    }

    @Override
    public String toString() {
        String base = String.format("Account[%s] Owner: %s, Balance: %s",
                accountNumber, owner, getMaskedBalance());
        if (blocked) {
            return base + " [ЗАБЛОКИРОВАН]";
        } else {
            return base;
        }
    }

    public static void main(String[] args) {
        BankAccount acc = new BankAccount("RU1234567890", "Иван Иванов", 150000.0, "1234");
        System.out.println(acc);

        System.out.println("Withdraw 1000 with PIN 0000: " + acc.withdraw("0000", 1000));
        System.out.println("Failed attempts: " + acc.getFailedAttempts());
        System.out.println("Withdraw 1000 with PIN 1111: " + acc.withdraw("1111", 1000));
        System.out.println("Failed attempts: " + acc.getFailedAttempts());
        System.out.println("Withdraw 1000 with PIN 2222: " + acc.withdraw("2222", 1000));
        System.out.println("Blocked: " + acc.isBlocked());
        System.out.println(acc);

        System.out.println("Withdraw with correct PIN after block: " + acc.withdraw("1234", 1000));

        acc.unblockAccount();
        System.out.println("Unblocked: " + !acc.isBlocked());
        System.out.println("Withdraw 50000 with correct PIN: " + acc.withdraw("1234", 50000));
        System.out.println("Balance (masked): " + acc.getMaskedBalance());
        System.out.println("Deposit 1000: " + acc.deposit(1000));
        System.out.println("Balance (masked): " + acc.getMaskedBalance());
    }
}

