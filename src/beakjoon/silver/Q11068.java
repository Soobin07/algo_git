package src.beakjoon.silver;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Q11068 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            boolean isPalindrome = false;

            for (int base = 2; base <= 64; base++) {
                if (check(n, base)) {
                    isPalindrome = true;
                    break;
                }
            }

            System.out.println(isPalindrome ? 1 : 0);
        }
    }

    static boolean check(int n, int base) {
        int[] arr = new int[32];
        int idx = 0;

        while (n > 0) {
            arr[idx++] = n % base;
            n /= base;
        }

        for (int i = 0; i < idx / 2; i++) {
            if (arr[i] != arr[idx - i - 1]) {
                return false;
            }
        }

        return true;
    }
}
