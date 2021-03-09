import java.util.*;

public class L6 {
    // Дан список, состоящий из упорядоченных по возрастанию списков
    // Вернуть результат их слияния
    public static List<Integer> f1(List<List<Integer>> list) {
        List<Integer> r = new LinkedList<>();
        for (List<Integer> l : list) {
            r = f2(r,l);
        }
        return r;
    }

    // слияние двух списков
    public static List<Integer> f2(List<Integer> l1, List<Integer> l2) {
        List<Integer> r = new LinkedList<>();
        ListIterator<Integer> i = l1.listIterator();
        ListIterator<Integer> j = l2.listIterator();
        while (i.hasNext() && j.hasNext()) {
            int x = i.next();
            int y = j.next();
            if (x < y) {
                // добавляем меньший элемент
                r.add(x);
                // возвращаем указатель в другом списке назад
                j.previous();
            } else {
                // добавляем меньший элемент
                r.add(y);
                // возвращаем указатель в другом списке назад
                i.previous();
            }
        }
        // добавляем элементы из более длинного списка
        while (i.hasNext()) {
            r.add(i.next());
        }
        while (j.hasNext()) {
            r.add(j.next());
        }
        return r;
    }

    public static void printList(List<Integer> list) {
        for (Integer el : list) {
            System.out.print(el + " ");
        }
        System.out.println();
    }
    public static void main(String [] args) {
        Random r = new Random();
        int n = r.nextInt(10);
        List<List<Integer>> outer = new LinkedList<>();
        for (int i=0; i<n; i++) {
            List<Integer> inner = new LinkedList<>();
            int k = r.nextInt(10);
            int p = r.nextInt(10);
            for (int j=0; j<k; j++) {
                inner.add(p);
                p = p + r.nextInt(10);
            }
            outer.add(inner);
        }

        System.out.println("List:");
        for (List<Integer> i : outer) {
            printList(i);
        }

        System.out.println("Joined:");
        List<Integer> joined = f1(outer);
        printList(joined);
    }
}
