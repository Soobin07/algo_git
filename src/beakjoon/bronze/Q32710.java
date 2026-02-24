package src.beakjoon.bronze;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q32710 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());


        if (N >= 1 && N <= 9) {
            System.out.println(1);
            return;
        }

        for (int i = 2; i <= 9; i++) {
            if (N % i == 0) {
                int j = N / i;
                if (j >= 1 && j <= 9) {
                    System.out.println(1);
                    return;
                }
            }
        }

        System.out.println(0);
    }
}
