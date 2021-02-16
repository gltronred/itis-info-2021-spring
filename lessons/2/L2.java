import java.io.*;

class Elem {
    int value;
    Elem next;

    Elem(int value, Elem next) {
        this.value = value;
        this.next = next;
    }
}

class List {
    Elem head;

    public List() {
        head = null;
    }
    public void print() {
        Elem p = head;
        while (p != null) {
            System.out.print(p.value + " ");
            p = p.next;
        }
        System.out.println();

    }
    public void addFirst(int value) {
        head = new Elem(value, head);
    }
    public void deleteFirst() {
        head = head.next;
    }
    public void addLast(int value) {
        if (head == null) {
            addFirst(value);
        } else {
            Elem p = head;
            while (p.next != null) {
                p = p.next;
            }
            p.next = new Elem(value, null);
        }
    }
}

public class L2 {
    public static void main(String[] args){
        List list1 = new List();
        list1.addFirst(6);
        list1.addFirst(5);
        list1.addFirst(4);
        list1.print();

        list1.addFirst(3);
        list1.print();

        list1.addLast(7);
        list1.print();

        List list2 = new List();
        list2.addLast(7);
        list2.print();
    }
}
