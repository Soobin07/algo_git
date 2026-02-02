package src.beakjoon.bronze;
import java.io.*;
import java.util.*;

public class Q5656 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int caseNum = 1;

        while (true) {
            String line = br.readLine();
            if (line == null) break;

            StringTokenizer st = new StringTokenizer(line);

            int a = Integer.parseInt(st.nextToken());
            String op = st.nextToken();
            int b = Integer.parseInt(st.nextToken());

            if (op.equals("E")) break;

            boolean result = false;

            switch (op) {
                case "<":  result = a < b;  break;
                case ">":  result = a > b;  break;
                case "<=": result = a <= b; break;
                case ">=": result = a >= b; break;
                case "==": result = a == b; break;
                case "!=": result = a != b; break;
            }

            sb.append("Case ")
              .append(caseNum++)
              .append(": ")
              .append(result)
              .append('\n');
        }

        System.out.print(sb);
    }
}
