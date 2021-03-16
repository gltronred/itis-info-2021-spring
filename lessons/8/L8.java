import java.util.*;

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
        HashMap<String,Integer> hm = new HashMap<>();
        for (Transaction txn : transactions) {
            String f = txn.getFrom();
            if (hm.containsKey(f)) {
                hm.put(f, hm.get(f) - txn.getAmount());
            } else {
                hm.put(f, -txn.getAmount());
            }

            String t = txn.getTo();
            if (!hm.containsKey(t)) {
                hm.put(t, 0);
            }
            hm.put(t, hm.get(t) + txn.getAmount());
        }
        return hm;
    }
    public static void printPositive(Map<String,Integer> balances) {
        for (Map.Entry<String,Integer> entry : balances.entrySet()) {
            if (entry.getValue() > 0) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
    public static Map<String,Map<String,Integer>> computeBalancesCur(List<Transaction> transactions) {
        HashMap<String,Map<String,Integer>> hm = new HashMap<>();
        for (Transaction txn : transactions) {
            String cur = txn.getCurrency();
            String f = txn.getFrom();
            if (!hm.containsKey(f)) {
                hm.put(f, new HashMap<>());
            }
            Map<String,Integer> famt = hm.get(f);
            if (!famt.containsKey(cur)) {
                famt.put(cur, 0);
            }
            famt.put(cur, famt.get(cur) - txn.getAmount());
            hm.put(f,famt);

            String t = txn.getTo();
            if (!hm.containsKey(t)) {
                hm.put(t, new HashMap<>());
            }
            Map<String,Integer> tamt = hm.get(t);
            if (!tamt.containsKey(cur)) {
                tamt.put(cur,0);
            }
            tamt.put(cur, tamt.get(cur) + txn.getAmount());
            hm.put(t,tamt);
        }
        return hm;
    }
    public static Set<String> computeCurrencies(List<Transaction> transactions) {
        HashSet<String> curs = new HashSet<>();
        for (Transaction txn : transactions) {
            curs.add(txn.getCurrency());
        }
        return curs;
    }
    public static void main(String[] args) {
        List<Transaction> txns = new LinkedList<Transaction>();
        txns.add(new Transaction("Alice","Bob",   "USD",  10));
        txns.add(new Transaction("Bob","Charlie", "USD",   5));
        txns.add(new Transaction("Dave","Charlie","EUR",   5));
        txns.add(new Transaction("Eve","Frank",   "RUB", 500));
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
        // 4
        System.out.println("Посчитать баланс с валютами");
        Map<String,Map<String,Integer>> bals = computeBalancesCur(txns);
        for (Map.Entry<String,Map<String,Integer>> entry : bals.entrySet()) {
            System.out.print(entry.getKey() + ": ");
            Map<String,Integer> amts = entry.getValue();
            for (Map.Entry<String,Integer> amt : amts.entrySet()) {
                System.out.print(amt.getKey() + " " + amt.getValue() + "; ");
            }
            System.out.println();
        }
        // 5
        System.out.println("Какие валюты встречаются?");
        Set<String> currencies = computeCurrencies(txns);
        for (String cur : currencies) {
            System.out.println(cur);
        }
    }
}
