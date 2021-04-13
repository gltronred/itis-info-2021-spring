import java.util.*;
import java.util.stream.*;

class Transaction {
    private String from;
    public String getFrom() { return from; }
    private String to;
    public String getTo() { return to; }
    private String currency;
    public String getCurrency() { return currency; }
    private int amount;
    public int getAmount() { return amount; }
    public Transaction(String from, String to, String currency, int amount) {
        this.from = from;
        this.to = to;
        this.currency = currency;
        this.amount = amount;
    }
}

public class L14 {
    public static void main(String[] args) {
        List<Transaction> txns = new LinkedList<Transaction>();
        txns.add(new Transaction("Alice","Bob",   "USD",  10));
        txns.add(new Transaction("Bob","Charlie", "USD",   5));
        txns.add(new Transaction("Dave","Charlie","EUR",   5));
        txns.add(new Transaction("Eve","Frank",   "RUB", 500));
        // 1
        // Посчитать баланс транзакций по людям
        // A: -10, B: 5, C: 10, D: -5, E: -500, F: 500
        Map<String,Integer> balances = new TreeMap<>();
    }
}
