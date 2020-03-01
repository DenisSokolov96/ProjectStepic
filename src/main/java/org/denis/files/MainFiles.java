package org.denis.files;

import java.io.*;
import java.nio.charset.Charset;

public class MainFiles {

    public static void main(String[] args) throws IOException {

        /************************************************************************/
        // InputStream последовательно возвращает четыре байта: 48 49 50 51.
        // Метод, вызванный для такого InputStream и кодировки ASCII, должен вернуть строку "0123".
        ByteArrayInputStream inputStream = new ByteArrayInputStream(new byte[]{48, 49, 50, 51});
        System.out.println( readAsString(inputStream, Charset.forName("ASCII")) );
        /************************************************************************/

        // /r/n -> /n
        //start_test();

        /************************************************************************/
    }

    /************************************************************************/

    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {

        InputStreamReader reader = new InputStreamReader(inputStream,charset);
        StringBuilder str = new StringBuilder();
        int a = 0;
        while ((a = reader.read()) != -1) {
            str.append((char)a);
        }

        return str.toString();
    }

    /**********************************************************************************/

    private static void start_test() throws IOException {
        System.out.println("Test Start");
        byte[] mass = new byte[]{65, 13, 10, 10, 13};

        ByteArrayInputStream in = new ByteArrayInputStream(mass);
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        convert(in, out);

        byte[] byte_out_mass = out.toByteArray();
        for (int a : byte_out_mass) {
            System.out.println(a);
        }
        System.out.println("Test End");


    }

    private static void convert(InputStream inputStream,OutputStream outputStream) throws IOException {

        int buf1 = inputStream.read();
        int buf2;

        while (buf1 != -1) {
            buf2 = inputStream.read();
            if (!(buf2 == 10 && buf1 == 13)) {
                outputStream.write(buf1);
            }
            buf1 = buf2;
        }
        outputStream.flush();
        inputStream.close();
    }
    /************************************************************************************************/

}
