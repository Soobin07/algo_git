package src.beakjoon.bronze;
import java.util.Scanner;

public class Q13235 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        int len = s.length();
        boolean isPalindrome = true;

        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println(isPalindrome ? "true" : "false");
    }
}
