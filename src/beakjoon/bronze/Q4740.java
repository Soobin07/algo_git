package src.beakjoon.bronze;
import java.io.*;

public class Q4740 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String line = br.readLine();
            if (line.equals("***")) break;
            sb.append(new StringBuilder(line).reverse()).append("\n");
        }

        System.out.print(sb);
    }
}
