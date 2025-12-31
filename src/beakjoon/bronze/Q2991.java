package src.beakjoon.bronze;
import java.util.Scanner;

public class Q2991 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int D = sc.nextInt();

        int P = sc.nextInt();
        int M = sc.nextInt();
        int N = sc.nextInt();

        check(P, A, B, C, D);
        check(M, A, B, C, D);
        check(N, A, B, C, D);
    }

    static void check(int t, int A, int B, int C, int D) {
        int count = 0;

        int r1 = t % (A + B);
        if (r1 != 0 && r1 <= A) {
            count++;
        }

        int r2 = t % (C + D);
        if (r2 != 0 && r2 <= C) {
            count++;
        }

        System.out.println(count);
    }
}
