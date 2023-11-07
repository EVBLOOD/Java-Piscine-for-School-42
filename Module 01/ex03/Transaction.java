import java.util.UUID;

public class Transaction {

    public enum Transfer {
        debits, // debits refer to incoming money
        credits // credits refer to outgoing money
    };

    String Identifier;
    User Recipient;
    User Sender;
    Transfer category;
    int amount;

    public String getIdentifier() {
        return Identifier;
    }

    public User getRecipient() {
        return Recipient;
    }

    public User getSender() {
        return Sender;
    }

    public int getAmount() {
        return amount;
    }

    public Transfer getCategory() {
        return category;
    }

    public String getCategoryAlias() {
        if (category.equals(Transfer.credits))
            return "OUTCOME";
        return "INCOME";
    }

    public Transaction(User Sender, User Recipient, Transfer category, int amount) {
        Identifier = UUID.randomUUID().toString();
        if (category == Transfer.debits) {
            if (amount < 0) {
                System.err.println("shit happens but you recieving negative number can't happen.");
                System.exit(-1);
            }
            Sender.setBalance(Sender.getBalance() + amount);
            // System.out.printf("%s -> %s %d, INCOME, transaction %s%n", Sender.getName(),
            // Recipient.getName(), amount,
            // this.Identifier);
        } else if (category == Transfer.credits) {
            if (amount > 0) {
                System.err.println("shit happens but you revieving positive number can't happen.");
                System.exit(-1);
            }
            if (Sender.getBalance() < amount * -1) {
                System.err.println("again shit could happen but you sending what you don't have isn't.");
                System.exit(-1);
            }
            Recipient.setBalance(amount + Recipient.getBalance());
        }
        this.amount = amount;
        this.Recipient = Recipient;
        this.Sender = Sender;
        this.category = category;
    }
}
