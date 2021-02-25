import java.util.*;

public class L4 {
    // Оставить в списке только элементы, которые делятся на 3,
    // после которых стоит элемент, который делится на 5
    //
    // >>> 3 5 2 6 15 25 0 10 1 4
    // 3 6 15 0
    public static void f1(LinkedList<Integer> list) {
        return;
    }
    public static void main(String[] args) {
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
        list.add(4);

        f1(list);
        for (Integer el : list) {
            System.out.print(el + " ");
        }
        System.out.println();
    }
}
