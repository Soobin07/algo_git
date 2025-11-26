package src.beakjoon.bronze;
import java.util.*;

public class Q28214 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 묶음 수
        int k = sc.nextInt(); // 묶음 당 빵 수
        int p = sc.nextInt(); // 0이 p 이상이면 불합격

        int[] arr = new int[n * k];
        for (int i = 0; i < n * k; i++) {
            arr[i] = sc.nextInt();
        }

        int result = 0;

        for (int i = 0; i < n; i++) {
            int zero = 0;
            for (int j = 0; j < k; j++) {
                if (arr[i * k + j] == 0) zero++;
            }
            if (zero < p) result++; // 0이 p보다 적으면 판매 가능
        }

        System.out.println(result);
    }
}
