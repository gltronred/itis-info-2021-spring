import java.util.*;

public class L3 {
    public static boolean isSorted(List<Integer> list) {
        boolean sorted = true;
        ListIterator<Integer> iter = list.listIterator();
        if (iter.hasNext()) {
            Integer prev = iter.next();
            while (iter.hasNext() && sorted) {
                Integer cur = iter.next();
                sorted &= (prev <= cur);
                prev = cur;
            }
        }
        return sorted;
    }

    public static void printList(List<Integer> list) {
        System.out.print("[");
        ListIterator<Integer> iter = list.listIterator();
        while (iter.hasNext()) {
            System.out.print(iter.next());
            if (iter.hasNext()) {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }

    public static void smoothList(List<Integer> list) {
        ListIterator<Integer> iter = list.listIterator();
        if (iter.hasNext()) {
            Integer prev = iter.next();
            while (iter.hasNext()) {
                Integer cur = iter.next();
                if (prev > cur) {
                    iter.set(prev);
                    cur = prev;
                }
                prev = cur;
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> demo1 = new LinkedList<>();
        for (int i = 0; i < 10; i++)
            demo1.add(2*i+1);

        Random random = new Random();
        List<Integer> demo2 = new LinkedList<>();
        for(int i=0; i<10; i++)
            demo2.add(random.nextInt(10));

        List<Integer> demo3 = new LinkedList<>();

        printList(demo1);
        System.out.println(isSorted(demo1));

        printList(demo2);
        System.out.println(isSorted(demo2));
        smoothList(demo2);
        System.out.println(isSorted(demo2));
        printList(demo2);

        printList(demo3);
        System.out.println(isSorted(demo3));
        smoothList(demo3);
        System.out.println(isSorted(demo3));
        printList(demo3);
    }
}
