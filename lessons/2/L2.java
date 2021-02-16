import java.io.*;

class Elem {
    int value;
    Elem next;

    Elem(int value, Elem next) {
        this.value = value;
        this.next = next;
    }
}

public class L2 {
    public static void main(String[] args){
        Elem root = new Elem(4,
                    new Elem(5,
                    new Elem(6,
                    null)));

        // print list
        Elem p = root;
        while (p != null) {
            System.out.println(p.value);
            p = p.next;
        }
       
    }
}
