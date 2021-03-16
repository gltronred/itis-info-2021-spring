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
        int balance = 0;
        for (Transaction txn : transactions) {
            if (txn.getFrom().equals(who)) {
                balance -= txn.getAmount();
            }
            if (txn.getTo().equals(who)) {
                balance += txn.getAmount();
            }
        }
        return balance;
    }
    public static Map<String,Integer> computeBalances(List<Transaction> transactions) {
        return new HashMap<>();
    }
    public static void printPositive(Map<String,Integer> balances) {
        for (Map.Entry<String,Integer> entry : balances.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
    public static void main(String[] args) {
        List<Transaction> txns = new LinkedList<Transaction>();
        txns.add(new Transaction("Alice","Bob",10));
        txns.add(new Transaction("Bob","Charlie",5));
        // 1
        System.out.println(computeBalance(txns, "Bob"));
        // 2
        Map<String,Integer> balances = computeBalances(txns);
        for (Map.Entry<String,Integer> entry : balances.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        // 3
        System.out.println("Who increased balance:");
        printPositive(balances);
    }
}
