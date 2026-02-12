package src.beakjoon.silver;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q6550 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;

        while ((input = br.readLine()) != null) {
            if (input.trim().isEmpty()) continue;
            StringTokenizer st = new StringTokenizer(input);
            String s = st.nextToken();
            String t = st.nextToken();

            int idx = 0;
            for (int i = 0; i < t.length() && idx < s.length(); i++) {
                if (s.charAt(idx) == t.charAt(i)) {
                    idx++;
                }
            }

            if (idx == s.length()) bw.write("Yes\n");
            else bw.write("No\n");
        }

        bw.flush();
    }
}
