package src.beakjoon.bronze;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Q32775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int S = Integer.parseInt(br.readLine().trim());
        int F = Integer.parseInt(br.readLine().trim());

        if (S <= F) {
            System.out.println("high speed rail");
        } else {
            System.out.println("flight");
        }
    }
}
