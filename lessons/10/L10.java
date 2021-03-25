import java.io.*;
import java.util.*;

public class L10 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("input.txt");
        // = new FileInputStream("../10/input.txt");
        // = new FileInputStream("..\\input.txt");
        // = new FileInputStream("/tmp/10/input.txt");
        // = new FileInputStream("C:\\Users\\admin\\input.txt");
        Scanner sc = new Scanner(fis);

        int s = 0;
        while (sc.hasNextLine()) {
            s += sc.nextLine().length() + 1;
        }

        FileOutputStream fos = new FileOutputStream("output.txt");
        PrintWriter pw = new PrintWriter(fos);

        pw.println(s);
        pw.close();
    }
}
