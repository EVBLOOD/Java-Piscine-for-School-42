// import java.util.UUID;

public interface TransactionsList {

    public void addTransaction(User Sender, User Recipient, Transaction.Transfer category, int amount);

    public void removeTransaction(String id);

    public Transaction[] toArray();
}
