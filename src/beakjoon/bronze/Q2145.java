package src.beakjoon.bronze;
import java.util.Scanner;

public class Q2145 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int n = sc.nextInt();
            if (n == 0) break;

            while (n >= 10) {
                int sum = 0;
                while (n > 0) {
                    sum += n % 10;
                    n /= 10;
                }
                n = sum;
            }

            System.out.println(n);
        }
    }
}
