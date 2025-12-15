package src.beakjoon.bronze;
import java.util.*;

public class Q13223 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] now = sc.nextLine().split(":");
        String[] target = sc.nextLine().split(":");

        int nowSec =
                Integer.parseInt(now[0]) * 3600 +
                Integer.parseInt(now[1]) * 60 +
                Integer.parseInt(now[2]);

        int targetSec =
                Integer.parseInt(target[0]) * 3600 +
                Integer.parseInt(target[1]) * 60 +
                Integer.parseInt(target[2]);

        int diff = targetSec - nowSec;

        if (diff <= 0) {
            diff += 24 * 3600;
        }

        int h = diff / 3600;
        diff %= 3600;
        int m = diff / 60;
        int s = diff % 60;

        System.out.printf("%02d:%02d:%02d\n", h, m, s);
    }
}
