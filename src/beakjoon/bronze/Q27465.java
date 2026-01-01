package src.beakjoon.bronze;
import java.io.*;

public class Q27465 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        if (N <= 3) {
            System.out.println(4);
        } else if (N % 2 == 0) {
            System.out.println(N);
        } else {
            System.out.println(N + 1);
        }
    }
}
