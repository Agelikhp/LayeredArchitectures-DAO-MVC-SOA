import java.util.List;

public interface AccountService {
    Account getAccount(String accountId);
    void deposit(String accountId, double amount);
    void withdraw(String accountId, double amount);
    void deleteAccount(String accountId);
    List<Account> findAccountsByHolderName(String holderName);
}