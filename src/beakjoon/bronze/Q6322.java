package src.beakjoon.bronze;
import java.io.*;
import java.util.*;

public class Q6322 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = 1;

        while (true) {
            String line = br.readLine();
            if (line == null) break;

            StringTokenizer st = new StringTokenizer(line);
            double a = Double.parseDouble(st.nextToken());
            double b = Double.parseDouble(st.nextToken());
            double c = Double.parseDouble(st.nextToken());

            // 종료 조건
            if (a == 0 && b == 0 && c == 0) break;

            sb.append("Triangle #").append(tc).append("\n");

            boolean impossible = false;

            if (a == -1) {
                double val = c * c - b * b;
                if (val <= 0) {
                    impossible = true;
                } else {
                    a = Math.sqrt(val);
                    sb.append(String.format("a = %.3f\n", a));
                }
            } else if (b == -1) {
                double val = c * c - a * a;
                if (val <= 0) {
                    impossible = true;
                } else {
                    b = Math.sqrt(val);
                    sb.append(String.format("b = %.3f\n", b));
                }
            } else if (c == -1) {
                c = Math.sqrt(a * a + b * b);
                sb.append(String.format("c = %.3f\n", c));
            }

            if (impossible) {
                sb.append("Impossible.\n");
            }

            sb.append("\n"); // 테스트 케이스 사이 빈 줄
            tc++;
        }

        System.out.print(sb.toString());
    }
}
