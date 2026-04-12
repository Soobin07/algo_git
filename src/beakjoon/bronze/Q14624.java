package src.beakjoon.bronze;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q14624 {

    static int N;

    static void draw(int idx, int space) {
        if (idx < 0) return;

        // 왼쪽 공백
        for (int i = 0; i < idx; i++) {
            System.out.print(" ");
        }

        System.out.print("*");

        // 가운데 공백
        for (int i = 0; i < space; i++) {
            System.out.print(" ");
        }

        System.out.println("*");

        draw(idx - 1, space + 2);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        if (N % 2 == 0) {
            System.out.println("I LOVE CBNU");
            return;
        }

        for (int i = 0; i < N; i++) {
            System.out.print("*");
        }
        System.out.println();

        int mid = N / 2;

        for (int i = 0; i < mid; i++) {
            System.out.print(" ");
        }
        System.out.println("*");

        draw(mid - 1, 1);
    }
}
