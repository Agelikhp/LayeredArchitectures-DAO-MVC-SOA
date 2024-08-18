import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountServiceImpl implements AccountService {
    private Map<String, Account> accounts = new HashMap<>();

    public AccountServiceImpl() {
        // Δημιουργία μερικών λογαριασμών για δοκιμές
        accounts.put("1", new Account("1", "John Doe", 1000.0));
        accounts.put("2", new Account("2", "Jane Smith", 2000.0));
        accounts.put("3", new Account("3", "John Doe", 1500.0)); // Δεύτερος λογαριασμός με το ίδιο όνομα
    }

    @Override
    public Account getAccount(String accountId) {
        return accounts.get(accountId);
    }

    @Override
    public void deposit(String accountId, double amount) {
        Account account = accounts.get(accountId);
        if (account != null) {
            account.setBalance(account.getBalance() + amount);
        }
    }

    @Override
    public void withdraw(String accountId, double amount) {
        Account account = accounts.get(accountId);
        if (account != null && account.getBalance() >= amount) {
            account.setBalance(account.getBalance() - amount);
        }
    }

    @Override
    public void deleteAccount(String accountId) {
        accounts.remove(accountId);
    }

    @Override
    public List<Account> findAccountsByHolderName(String holderName) {
        List<Account> foundAccounts = new ArrayList<>();
        for (Account account : accounts.values()) {
            if (account.getAccountHolderName().equalsIgnoreCase(holderName)) {
                foundAccounts.add(account);
            }
        }
        return foundAccounts;
    }
}