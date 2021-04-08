import java.util.*;
import java.util.stream.*;

public class L13 {
    public static void main(String[] args) {
        long n = Stream
            .iterate(1, x -> x+1)
            .map(x -> x+10)
            .filter(x -> x % 2 == 1)
            .limit(10)
            .map(x -> {
                    System.out.println(x);
                    return x;
                })
            .count();
        System.out.println("n=" + n);

        Stream
            .of(1,2,3,4)
            .map(x -> x*x)
            .forEach(x -> System.out.println(x));

        System.out.println("Randoms");

        Random r = new Random();
        Stream
            .generate(() -> r.nextInt(15))
            .limit(15)
            .forEach(x -> System.out.println(x));
    }
}
