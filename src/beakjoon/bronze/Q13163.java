package src.beakjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Q13163 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());

        StringBuilder output = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            String[] arr = line.split(" ");

            StringBuilder sb = new StringBuilder("god");
            for (int j = 1; j < arr.length; j++) {
                sb.append(arr[j]);
            }

            output.append(sb).append('\n');
        }

        System.out.print(output);
    }
}
