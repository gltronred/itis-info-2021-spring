import java.util.*;

public class L3 {
    public static boolean isSorted(List<Integer> list) {
        boolean sorted = true;
        ListIterator<Integer> iter = list.listIterator();
        Integer prev = iter.next();
        while (iter.hasNext() && sorted) {
            Integer cur = iter.next();
            sorted &= (prev <= cur);
            prev = cur;
        }
        return sorted;
    }

    public static void main(String[] args) {
        List<Integer> demo1 = new LinkedList<>();
        for (int i = 0; i < 10; i++)
            demo1.add(2*i+1);

        Random random = new Random();
        List<Integer> demo2 = new LinkedList<>();
        for(int i=0; i<10; i++)
            demo2.add(random.nextInt(10));

        System.out.println(isSorted(demo1));
        System.out.println(isSorted(demo2));
    }
}
