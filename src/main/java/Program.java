import java.io.*;

public class Program {
    public static void main(String[] args) throws IOException {

        InputStream inputStream = Program.class.getResourceAsStream("/sample.puml");

        final int bufferSize = 1024;
        final char[] buffer = new char[bufferSize];
        final StringBuilder out = new StringBuilder();
        Reader in = new InputStreamReader(inputStream, "UTF-8");
        for (; ; ) {
            int rsz = in.read(buffer, 0, buffer.length);
            if (rsz < 0)
                break;
            out.append(buffer, 0, rsz);
        }

        System.out.println("Hello antlr");
        System.out.println(out.toString());

    }
}
