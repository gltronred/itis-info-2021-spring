import java.io.*;
import java.util.*;

public class L10 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("input.txt");
        Scanner sc = new Scanner(fis);

        int a = sc.nextInt();
        int b = sc.nextInt();

        FileOutputStream fos = new FileOutputStream("output.txt");
        PrintWriter pw = new PrintWriter(fos);

        pw.println(a+b);

        pw.close();
    }
}
