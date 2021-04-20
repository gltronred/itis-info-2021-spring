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
    public String toString() {
        return from + " " + to + " " + currency + " " + amount;
    }
}

public class L15 {
    public static void main(String[] args) {
        List<Transaction> txns = new LinkedList<Transaction>();
        txns.add(new Transaction("Alice","Bob",   "USD",  10));
        txns.add(new Transaction("Bob","Charlie", "USD",   5));
        txns.add(new Transaction("Dave","Charlie","EUR",   5));
        txns.add(new Transaction("Eve","Frank",   "RUB", 500));

        // Сгруппировать транзакции <10 по получателям
        Map<String, List<Transaction>> res = txns.stream()
            .filter(t -> t.getAmount() < 10)
            .collect(Collectors.groupingBy(Transaction::getTo));

        // Вывести
        for (Map.Entry<String,List<Transaction>> entry : res.entrySet()) {
            String ts = entry.getValue().stream()
                .map(Transaction::toString)
                .collect(Collectors.joining(","));
            System.out.println(entry.getKey() + ": " + ts);
        }

        // Сгруппировать транзакции USD по размеру:
        // 0<=x<10, 10<=x<100, 100<=x<1000, 1000<=x
        Map<Integer, List<Transaction>> res2 = txns.stream()
            .filter(t -> t.getCurrency().equals("USD"))
            .collect(Collectors.groupingBy(t -> {
                        int x = t.getAmount();
                        if (x < 10) return 0;
                        if (x < 100) return 10;
                        if (x < 1000) return 100;
                        return 1000;
                    }));

        // Вывести
        for (Map.Entry<Integer,List<Transaction>> entry : res2.entrySet()) {
            String ts = entry.getValue().stream()
                .map(Transaction::toString)
                .collect(Collectors.joining(","));
            System.out.println(entry.getKey() + ": " + ts);
        }
    }
}
