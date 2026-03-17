package src.beakjoon.bronze;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Q3035 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        int R = Integer.parseInt(input[0]);
        int C = Integer.parseInt(input[1]);
        int ZR = Integer.parseInt(input[2]);
        int ZC = Integer.parseInt(input[3]);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < R; i++) {
            String line = br.readLine();

            StringBuilder expandedLine = new StringBuilder();
            for (int j = 0; j < C; j++) {
                char ch = line.charAt(j);
                for (int k = 0; k < ZC; k++) {
                    expandedLine.append(ch);
                }
            }

            for (int j = 0; j < ZR; j++) {
                sb.append(expandedLine).append('\n');
            }
        }

        System.out.print(sb);
    }
}
