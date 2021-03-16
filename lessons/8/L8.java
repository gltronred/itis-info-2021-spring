import java.util.*;

class Transaction {
    private String from;
    public String getFrom() { return from; }
    private String to;
    public String getTo() { return to; }
    private int amount;
    public int getAmount() { return amount; }
    public Transaction(String from, String to, int amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }
}

public class L8 {
    public static int computeBalance(List<Transaction> transactions, String who) {
        return 0;
    }
    public static void main(String[] args) {
        List<Transaction> txns = new LinkedList<Transaction>();
        txns.add(new Transaction("Alice","Bob",10));
        txns.add(new Transaction("Bob","Charlie",5));
        System.out.println(computeBalance(txns, "Bob"));
    }
}
