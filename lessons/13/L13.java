import java.util.*;
import java.util.stream.*;

public class L13 {
    public static boolean isPrime(int n) {
        long m = Stream
            .iterate(1, x -> x+1)
            .limit((long)Math.sqrt(n))
            .filter(x -> n % x == 0)
            .count();
        return m==1 && n!=1;
    }
    public static void main(String[] args) {
        Stream.of(1,2,5,15,49,101)
            .forEach(x -> System.out.println(x + " - " + isPrime(x)));

        // long n = Stream
        //     .iterate(1, x -> x+1)
        //     .map(x -> x+10)
        //     .filter(x -> x % 2 == 1)
        //     .limit(10)
        //     .map(x -> {
        //             System.out.println(x);
        //             return x;
        //         })
        //     .count();
        // System.out.println("n=" + n);

        // Stream
        //     .of(1,2,3,4)
        //     .map(x -> x*x)
        //     .forEach(x -> System.out.println(x));

        // System.out.println("Randoms");

        // Random r = new Random();
        // Stream
        //     .generate(() -> r.nextInt(15))
        //     .limit(15)
        //     .forEach(x -> System.out.println(x));
    }
}
