
class NotEnoughMoneyException extends Exception {
    public NotEnoughMoneyException(String message) {
        super(message);
    }
}

class Account {
    private String owner;
    private int balance;
    private String accountNumber;

    public Account(String owner, int balance, String accountNumber) {
        this.owner = owner;
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }


    public void transfer(int amount) throws NotEnoughMoneyException {
        if (amount > balance) {
            throw new NotEnoughMoneyException("Niewystarczające środki na koncie. Dostępne środki: " + balance);
        }
        balance -= amount;
        System.out.println("Przelew na kwotę " + amount + " wykonany pomyślnie. Aktualne saldo: " + balance);
    }
}


public class main {
    public static void main(String[] args) {

        Account account = new Account("Jan Kowalski", 500, "123456789");

        try {
            account.transfer(600);
        } catch (NotEnoughMoneyException e) {
            System.out.println("Błąd: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Wystąpił nieoczekiwany błąd: " + e.getMessage());
        } finally {
            System.out.println("Aktualne saldo: " + account.getBalance());
        }
    }
}
