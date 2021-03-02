import java.util.*;

public class L5 {
    // Напишите функцию, которая возвращает
    // список из длин списков
    public static List<Integer> f1(List<List<Integer>> list) {
        List<Integer> lens = new LinkedList<>();
        //ListIterator<List<Integer>> it = list.listIterator();
        //while (it.hasNext()) {
        //    List<Integer> el = it.next();
        //    lens.add(el.size());
        //}
        for (List<Integer> el : list) {
            lens.add(el.size());
        }
        return lens;
    }

    // Напишите функцию, которая возвращает
    // список из сумм элементов
    public static List<Integer> f2(List<List<Integer>> list) {
        List<Integer> sums = new LinkedList<>();
        for (List<Integer> l : list) {
            int s = 0;
            for (Integer x : l) {
                s += x;
            }
            sums.add(s);
        }
        return sums;
    }

    // Напишите функцию, которая возвращает список, в котором
    // элементы списков объединены: вначале первый элемент
    // первого списка, потом первый элемент второго и т.д.
    // потом второй элемент первого списка, второй второго
    // и т.д.
    //
    // [[1,2,3],
    //  [4,5],
    //  [6,7],
    //  [],
    //  [8]]
    // [1,4,6,8,2,5,7,3]
    public static List<Integer> f3(List<List<Integer>> list) {
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

        System.out.println("Sums:");
        List<Integer> sums = f2(outer);
        printList(sums);

        System.out.println("Elems");
        List<Integer> els = f3(outer);
        printList(els);
    }
}
