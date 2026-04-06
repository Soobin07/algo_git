package src.beakjoon.bronze;
import java.util.*;

public class Q1855 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        String str = sc.next();

        int rows = str.length() / k;
        char[][] arr = new char[rows][k];

        int idx = 0;

        for (int i = 0; i < rows; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < k; j++) {
                    arr[i][j] = str.charAt(idx++);
                }
            } else {
                for (int j = k - 1; j >= 0; j--) {
                    arr[i][j] = str.charAt(idx++);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < k; j++) {
            for (int i = 0; i < rows; i++) {
                sb.append(arr[i][j]);
            }
        }

        System.out.println(sb.toString());
    }
}
