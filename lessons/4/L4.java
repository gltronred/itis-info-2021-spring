import java.util.*;

public class L4 {
    // Оставить в списке только элементы, которые делятся на 3,
    // после которых стоит элемент, который делится на 5
    //
    // >>> 3 5 2 6 15 25 0 10 1 6 4
    // 3 6 15 0
    public static void f1(LinkedList<Integer> list) {
        return;
    }

    // Оставить в списке только элементы, которые делятся на 3
    //
    // >>> 3 5 2 6 15 25 0 10 1 6 4
    // 3 6 15 0 6
    public static void f2(LinkedList<Integer> list) {
        return;
    }
    public static LinkedList<Integer> mkList() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(3);
        list.add(5);
        list.add(2);
        list.add(6);
        list.add(15);
        list.add(25);
        list.add(0);
        list.add(10);
        list.add(1);
        list.add(6);
        list.add(4);
        return list;
    }
    public static void printList(List<Integer> list) {
        for (Integer el : list) {
            System.out.print(el + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        List<Integer> list = mkList();
        f1(list);
        printList(list);

        list = mkList();
        f2(list);
        printList(list);
    }
}
