package src.beakjoon.bronze;
import java.util.*;

public class Q10174 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            String lower = str.toLowerCase();

            String reversed = new StringBuilder(lower).reverse().toString();

            if (lower.equals(reversed)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
