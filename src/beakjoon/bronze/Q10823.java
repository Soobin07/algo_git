package src.beakjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10823 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        String line;

        while ((line = br.readLine()) != null) {
            sb.append(line);
        }

        String s = sb.toString();

        String[] parts = s.split(",");

        long sum = 0;
        for (String num : parts) {
            sum += Integer.parseInt(num); 
        }

        System.out.println(sum);
    }
}
