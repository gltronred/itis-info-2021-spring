import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class L17 {
    public static void main(String[] args) {
        Files.lines(Paths.of("input.txt"))
            .filter(s -> 'A' <= s.charAt(0) && s.charAt(0) <= 'Z')
            .map(s -> s.split(" "))
            .filter(arr -> arr.length < 10)
            .flatMap(Arrays::stream)
            .skip(5)
            .filter(w -> w.length() > 7)
            .forEach(System.out::println);
    }
}
