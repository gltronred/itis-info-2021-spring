import java.util.*;

public class L4 {
    // Оставить в списке только элементы, которые делятся на 3,
    // после которых стоит элемент, который делится на 5
    //
    // >>> 3 5 2 6 15 25 0 10 1 6 4
    // 3 6 15 0
    //
    // (отладочный вывод закомментирован;
    // попробуйте раскомментировать и подумать над ним)
    public static void f1(LinkedList<Integer> list) {
        ListIterator<Integer> iter = list.listIterator();
        // Если нет ни одного элемента, ничего не делаем
        if (!iter.hasNext()) return;

        Integer prev = iter.next();
        while (iter.hasNext()) {
            Integer cur = iter.next();
            // System.out.println("next: " + prev + " " + cur);
            if (prev % 3 != 0 || cur % 5 != 0) {
                Integer d1 = iter.previous();
                Integer d2 = iter.previous();
                // System.out.println("prev: " + d1 + " " + d2);
                // System.out.println("del: " + d2);
                iter.remove();
                cur = iter.next();
                // System.out.println("move: " + cur);
            }
            prev = cur;
        }
        // Удаляем последний элемент - после него нет кратного 5
        iter.remove();
    }

    // Оставить в списке только элементы, которые делятся на 3
    //
    // >>> 3 5 2 6 15 25 0 10 1 6 4
    // 3 6 15 0 6
    public static void f2(LinkedList<Integer> list) {
        ListIterator<Integer> iter = list.listIterator();
        while (iter.hasNext()) {
            Integer el = iter.next();
            if (el % 3 != 0) {
                iter.remove();
            }
        }
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
        LinkedList<Integer> list = mkList();
        f1(list);
        printList(list);

        list = mkList();
        f2(list);
        printList(list);
    }
}
