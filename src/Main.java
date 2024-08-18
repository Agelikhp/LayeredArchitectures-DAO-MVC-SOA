import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AccountService accountService = new AccountServiceImpl();
        Scanner scanner = new Scanner(System.in);

        // Αναζήτηση λογαριασμού
        System.out.println("Enter Account ID to retrieve:");
        String accountId = scanner.nextLine();
        Account account = accountService.getAccount(accountId);

        if (account != null) {
            System.out.println("Account Holder: " + account.getAccountHolderName());
            System.out.println("Balance: " + account.getBalance());

            // Κατάθεση χρημάτων
            System.out.println("Enter amount to deposit:");
            double depositAmount = scanner.nextDouble();
            accountService.deposit(accountId, depositAmount);
            System.out.println("New Balance: " + accountService.getAccount(accountId).getBalance());

            // Ανάληψη χρημάτων
            System.out.println("Enter amount to withdraw:");
            double withdrawAmount = scanner.nextDouble();
            accountService.withdraw(accountId, withdrawAmount);
            System.out.println("New Balance: " + accountService.getAccount(accountId).getBalance());

            // Διαγραφή λογαριασμού
            System.out.println("Do you want to delete the account? (yes/no)");
            scanner.nextLine(); // Καθαρισμός του buffer
            String deleteResponse = scanner.nextLine();
            if (deleteResponse.equalsIgnoreCase("yes")) {
                accountService.deleteAccount(accountId);
                System.out.println("Account deleted.");
            }
        } else {
            System.out.println("Account not found.");
        }

        // Αναζήτηση λογαριασμών με βάση το όνομα του κατόχου
        System.out.println("Enter Account Holder Name to search:");
        String holderName = scanner.nextLine();
        List<Account> foundAccounts = accountService.findAccountsByHolderName(holderName);
        if (!foundAccounts.isEmpty()) {
            System.out.println("Found Accounts:");
            for (Account foundAccount : foundAccounts) {
                System.out.println("Account ID: " + foundAccount.getAccountId() + ", Balance: " + foundAccount.getBalance());
            }
        } else {
            System.out.println("No accounts found for holder name: " + holderName);
        }

        scanner.close();
    }
}