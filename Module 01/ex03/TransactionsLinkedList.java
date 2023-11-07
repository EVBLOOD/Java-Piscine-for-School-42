// import java.util.UUID;

public class TransactionsLinkedList implements TransactionsList {

    private class InnerTransactionsLinkedList {
        Transaction one;
        InnerTransactionsLinkedList next = null;
        InnerTransactionsLinkedList prev = null;

        InnerTransactionsLinkedList(Transaction x, InnerTransactionsLinkedList y) {
            one = x;
            prev = y;
        }

    }

    private InnerTransactionsLinkedList list;
    private InnerTransactionsLinkedList last;

    public TransactionsLinkedList() {
    }

    public void addTransaction(User Sender, User Recipient, Transaction.Transfer category, int amount) {
        if (list == null) {
            list = new InnerTransactionsLinkedList(new Transaction(Sender, Recipient, category, amount), null);
            last = list;
            return;
        }
        last.next = new InnerTransactionsLinkedList(new Transaction(Sender, Recipient, category, amount), last);
        last = last.next;
    }

    public void removeTransaction(String id) {
        while (list != null) {
            if (list.one.Identifier == id) {
                list.prev = list.next;
                if (list.next != null)
                    list.next = list.next.next;
                while (list != null && list.prev != null) {
                    list = list.prev;
                }
                return;
            }
            list = list.next;
        }
        while (list != null && list.prev != null) {
            list = list.prev;
        }
        throw new RuntimeException("TransactionNotFoundException");

    }

    public Transaction[] toArray() {
        int counter = 0;
        while (list != null) {
            counter++;
            list = list.next;
        }
        while (list != null && list.prev != null) {
            list = list.prev;
        }
        Transaction[] tmp = new Transaction[counter];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = list.one;
            list = list.next;
        }
        while (list != null && list.prev != null) {
            list = list.prev;
        }
        return tmp;
    }
}
