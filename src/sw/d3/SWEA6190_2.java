package sw.d3;

import java.util.Scanner;

public class SWEA6190_2 {
	static Scanner sc = new Scanner(System.in);
	 
    public static void main(String[] args) {
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            System.out.printf("#%d %d%n", tc, solution());
        }
    }
 
    static int solution() {
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
 
        int max = -1;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int mul = arr[i] * arr[j];
                if (isDanjo(mul)) {
                    max = Math.max(max, mul);
                }
            }
        }
        return max;
    }
 
    static boolean isDanjo(int num) {
        int after = num % 10;
        num /= 10;
        while (num > 0) {
            int before = num % 10;
            if (before > after) {
                return false;
            }
            after = before;
            num /= 10;
        }
        return true;
    }
}
