package src.beakjoon.bronze;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q6321 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            StringBuilder sb = new StringBuilder();
            sb.append("String #");
            sb.append(i+1);
            sb.append("\n");
            for (int j = 0; j < name.length(); j++) {
                char c = name.charAt(j);
                char next = (char) ((c - 'A' + 1) % 26 + 'A');
                sb.append(next);
            }

            System.out.println(sb.toString());

            if (i != n - 1) {
                System.out.println();
            }
        }
    }
}
