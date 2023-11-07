
public class Program {
    // debits: debits refer to incoming money
    // credits: credits refer to outgoing money

    public static void main(String[] args) {
        User x = new User("null", 500);
        User y = new User("me", 0);
        Transaction two = new Transaction(x, y, Transaction.Transfer.credits, -500);
        System.out.printf("%s -> %s %d, %s, transaction %s%n", two.getSender().getName(),
                two.getRecipient().getName(), two.getAmount(), two.getCategoryAlias(),
                two.getIdentifier());
        Transaction one = new Transaction(x, y, Transaction.Transfer.debits, 500);
        System.out.printf("%s -> %s +%d, %s, transaction %s%n", one.getSender().getName(),
                one.getRecipient().getName(), one.getAmount(), one.getCategoryAlias(),
                one.getIdentifier());
    }

}
// For example, John has transferred $500 to Mike. System saves the transaction
// for both users:
// John -> Mike, -500, OUTCOME, transaction ID
// Mike -> John, +500, INCOME, transaction ID