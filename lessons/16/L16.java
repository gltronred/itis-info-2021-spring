import java.io.*;
import java.nio.file.*;
import java.util.stream.*;

public class L16 {
    public static void main(String[] args) throws IOException {
        // передаём путь, где нужно
        // работать, используя аргументы
        // командной строки (args[0])
        Files.list(Paths.get(args[0]))
            .flatMap(p -> {
                    try {
                        if (Files.isRegularFile(p))
                            return Stream.of(p);
                        else
                            return Files.list(p);
                    } catch (IOException e) {
                        return Stream.empty();
                    }
                })
            .filter(Files::isRegularFile)
            .filter(p -> p.getFileName()
                        .toString()
                        .endsWith(".java"))
            .forEach(System.out::println);
    }
}
