package wallet.model;

public class Account {
    private String accountName;
    private double balance;
    private String currency;

    // Constructor
    public Account(String accountName, double balance, String currency) {
        this.accountName = accountName;
        this.balance = balance;
        this.currency = currency;
    }
    //metodo para crear nueva cuenta
    public static Account createNewAccount(String accountName, double balance, String currency) {
        return new Account(accountName, balance, currency);
    }

    // Métodos getters y setters
    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    // Método para depositar fondos en la cuenta
    public void deposit(double amount) {
        this.balance += amount;
    }

    // Método para retirar fondos de la cuenta
    public void withdraw(double amount) {
        if (amount <= this.balance) {
            this.balance -= amount;
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    // Método para mostrar la información de la cuenta
    public void displayAccountInfo() {
        System.out.println("Nombre de la cuenta: " + this.accountName);
        System.out.println("Saldo: " + this.balance + " " + this.currency);
    }
    // Método para convertir el saldo de la cuenta a dólares
    public double convertToUSD(double exchangeRate) {
        if ("USD".equals(currency)) {
            return balance; // Si la cuenta ya está en dólares, no es necesario convertir
        } else {
            return balance * exchangeRate; // Si la cuenta está en otra moneda, aplicamos el tipo de cambio
        }
    }

    // Método para convertir el saldo de la cuenta de dólares a la moneda de la cuenta
    public double convertFromUSD(double exchangeRate) {
        if ("USD".equals(currency)) {
            return balance; // Si la cuenta ya está en dólares, no es necesario convertir
        } else {
            return balance / exchangeRate; // Si la cuenta está en otra moneda, aplicamos el tipo de cambio inverso
        }
    }
}

