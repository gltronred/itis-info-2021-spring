import java.util.*;

public class L9 {
    static class Transaction {
        private int seconds;
        public int getTime() { return seconds; }
        private String from;
        public String getFrom() { return from; }
        private String to;
        public String getTo() { return to; }
        private String currency;
        public String getCurrency() { return currency; }
        private int amount;
        public int getAmount() { return amount; }
        public Transaction(int start, String from, String to, String currency, int amount) {
            this.seconds = start;
            this.from = from;
            this.to = to;
            this.currency = currency;
            this.amount = amount;
        }
    }

    static class Price {
        private int time;
        public int getTime() { return time; }
        private String currency;
        public String getCurrency() { return currency; }
        private int price;
        public int getPrice() { return price; }
        public Price(int time, String currency, int price) {
            this.time = time;
            this.currency = currency;
            this.price = price;
        }
    }

    public static void updateWithDefault(Map<String,Integer> m, int def, String k, int d) {
        if (!m.containsKey(k)) {
            m.put(k,def);
        }
        m.put(k, m.get(k) + d);
    }

    // Посчитать баланс
    // Транзакции переводятся в валюту в момент транзакции
    public static Map<String,Integer> computeBalances(List<Price> prices, List<Transaction> txns) {
        HashMap<String,Integer> hm = new HashMap<>();
        HashMap<String,TreeMap<Integer,Integer>> priceMap = new HashMap<>();
        for (Price p : prices) {
            if (!priceMap.containsKey(p.getCurrency())) {
                priceMap.put(p.getCurrency(), new TreeMap<>());
            }
            TreeMap<Integer,Integer> pm = priceMap.get(p.getCurrency());
            pm.put(p.getTime(), p.getPrice());
            priceMap.put(p.getCurrency(), pm);
        }
        for (Transaction txn : txns) {
            Integer actual = priceMap
                .get(txn.getCurrency())
                .lowerEntry(txn.getTime())
                .getValue();

            int amount = txn.getAmount() * actual;

            updateWithDefault(hm, 0, txn.getFrom(), -amount);
            updateWithDefault(hm, 0, txn.getTo(),    amount);
        }
        return hm;
    }

    public static void print(Map<String,Integer> balances) {
        for (Map.Entry<String,Integer> entry : balances.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        List<Transaction> txns = new LinkedList<Transaction>();
        txns.add(new Transaction(10,"Alice","Bob",   "USD",  10));
        txns.add(new Transaction(20,"Bob","Charlie", "USD",   5));
        txns.add(new Transaction(20,"Dave","Charlie","EUR",   5));
        txns.add(new Transaction(50,"Eve","Frank",   "RUB", 500));

        List<Price> prices = new LinkedList<>();
        prices.add(new Price(0,"USD",75));
        prices.add(new Price(0,"EUR",90));
        prices.add(new Price(0,"RUB",1));
        prices.add(new Price(18,"USD",80));
        prices.add(new Price(19,"EUR",80));
        prices.add(new Price(40,"EUR",90));
        prices.add(new Price(41,"USD",75));
        prices.add(new Price(49,"RUB",2));

        // 1
        Map<String,Integer> balances = computeBalances(prices,txns);
        print(balances);
    }
}
