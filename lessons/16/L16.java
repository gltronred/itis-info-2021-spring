import java.io.*;
import java.nio.file.*;
import java.util.stream.*;

public class L16 {
    public static void main(String[] args) throws IOException {
        // передаём путь, где нужно
        // работать, используя аргументы
        // командной строки (args[0])
        Files.list(Paths.get(args[0]))
            // для каждого пути возвращаем Stream
            // - для файла - сам этот файл
            // - для папки - содержимое папки
            // - если ошибка - пустой Stream
            // ошибка ловится, поскольку иначе
            // не скомпилируется
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
            // оставляем только те пути,
            // которые обычные файлы (не папки)
            .filter(Files::isRegularFile)
            // оставляем только те пути,
            // имя файла в которых
            // заканчивается на .java
            .filter(p -> p.getFileName()
                        .toString()
                        .endsWith(".java"))
            // выводим каждый такой путь
            .forEach(System.out::println);
    }
}
