import java.util.*;

public class L5 {
    // Напишите функцию, которая возвращает список из длин списков
    public static List<Integer> f1(List<List<Integer>> list) {
        return new LinkedList<>();
    }

    public static void printList(List<Integer> list) {
        for (Integer el : list) {
            System.out.print(el + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Random r = new Random();
        int n = 10;
        List<List<Integer>> outer = new LinkedList<>();
        for (int i=0; i<n; i++) {
            List<Integer> inner = new LinkedList<>();
            int k = r.nextInt(10);
            for (int j=0; j<k; j++) {
                inner.add(r.nextInt(100));
            }
            outer.add(inner);
        }

        System.out.println("List:");
        for (List<Integer> i : outer) {
            printList(i);
        }

        System.out.println("Lengths:");
        List<Integer> lens = f1(outer);
        printList(lens);
    }
}
