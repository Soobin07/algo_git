package src.beakjoon.bronze;
import java.util.*;

public class Q9366 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 1; i <= T; i++) {
            int[] arr = new int[3];
            arr[0] = sc.nextInt();
            arr[1] = sc.nextInt();
            arr[2] = sc.nextInt();

            Arrays.sort(arr);
            int a = arr[0];
            int b = arr[1];
            int c = arr[2];

            String result;

            if (a + b <= c) {
                result = "invalid!";
            } else if (a == b && b == c) {
                result = "equilateral";
            } else if (a == b || b == c) {
                result = "isosceles";
            } else {
                result = "scalene";
            }

            System.out.println("Case #" + i + ": " + result);
        }

        sc.close();
    }
}
