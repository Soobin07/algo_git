package src.beakjoon.bronze;

import java.util.Scanner;

public class Q10474 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            if (A == 0 && B == 0) break;

            int q = A / B;   // 몫
            int r = A % B;   // 나머지

            System.out.println(q + " " + r + " / " + B);
        }

        sc.close();
    }
}
