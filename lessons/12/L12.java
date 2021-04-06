
import java.io.*;

public class L12 {
    public static void main(String[] args) throws IOException {
        FileInputStream in = new FileInputStream("/tmp/bad.bmp");

        byte[] header = new byte[138];

        int r0 = in.read(header);
        System.out.println("R0:" + r0);

        if (header[0] != 0x42 || header[1] != 0x4d) {
            System.out.println("Not a BMP!");
            return;
        } else {
            System.out.println("BMP");
        }

        System.out.println("Size: " + header[0x0e] + " " + header[0x0f] + " " + header[0x10] + " " + header[0x11]);
        int h = 0, w = 0;
        // надо бы ещё проверить, что остальные
        // байты равны нулю, но это самостоятельно
        // добавьте
        if (header[0x0e] == 12) {
            // CORE
            w = header[0x12] + header[0x13] * 256;
            h = header[0x14] + header[0x15] * 256;
        } else if (header[0x0e] == 40 ||
                   header[0x0e] == 108 ||
                   header[0x0e] == 124) {
            // V3-V5
            for (int i=3; i>=0; i--) {
                w <<= 8;
                // java is bad when working with bytes
                w |= (0xff & header[0x12 + i]);
            }
            for (int i=3; i>=0; i--) {
                h <<= 8;
                h |= (0xff & header[0x16 + i]);
            }
        } else {
            System.out.println("Bitmap version is unknown");
        }
        System.out.println(w + "x" + h);
    }
}
