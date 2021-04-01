import java.io.*;
import java.util.*;

public class L11 {
    public static void main(String[] args) {
        Queue<File> q = new LinkedList<>();
        q.offer(new File("."));
        while (q.peek() != null) {
            File cur = q.poll();
            if (cur.isFile() &&
                cur.getName().endsWith(".java")) {
                System.out.println(cur.getName());
            }
            if (cur.isDirectory()) {
                File[] subfiles = cur.listFiles();
                for (File f : subfiles) {
                    q.offer(f);
                }
            }
        }
    }
}
