package src.beakjoon.bronze;
import java.util.*;

public class Q21866 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] limit = {100, 100, 200, 200, 300, 300, 400, 400, 500};
        int sum = 0;
        boolean hacker = false;

        for (int i = 0; i < 9; i++) {
            int score = sc.nextInt();
            sum += score;

            if (score > limit[i]) {
                hacker = true;
            }
        }

        if (hacker) {
            System.out.println("hacker");
        } else if (sum >= 100) {
            System.out.println("draw");
        } else {
            System.out.println("none");
        }
    }
}
