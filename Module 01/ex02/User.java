import java.util.UUID;

public class User {

    // UUID Identifier;
    int Identifier;
    String Name;
    int Balance;

    public User(String Name, int Balance) { // It is necessary to check the initial user balance (it cannot be negative)
        if (Balance < 0) {
            System.err.println(
                    "balance cannot be negative");
            System.exit(-1);
        }
        // Identifier = UUID.randomUUID();
        Identifier = UserIdsGenerator.getInstance().generateId();
        this.Balance = Balance;
        this.Name = Name;
    }

    // public UUID getIdentifier() {
    // return Identifier;
    // }

    public String getName() {
        return Name;
    }

    public int getBalance() {
        return Balance;
    }

    public void setBalance(int Balance) {
        this.Balance = Balance;
    }

    public int getIdentifier() {
        return Identifier;
    }
}
