package src.beakjoon.bronze;
import java.util.Scanner;

public class Q31775 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean l = false, k = false, p = false;

        for (int i = 0; i < 3; i++) {
            String s = sc.next();
            char first = s.charAt(0);

            if (first == 'l') l = true;
            else if (first == 'k') k = true;
            else if (first == 'p') p = true;
        }

        if (l && k && p) {
            System.out.println("GLOBAL");
        } else {
            System.out.println("PONIX");
        }
    }
}
