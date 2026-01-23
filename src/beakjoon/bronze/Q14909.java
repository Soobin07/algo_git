package src.beakjoon.bronze;
import java.util.Scanner;

public class Q14909 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;

        while (sc.hasNextInt()) { // EOF까지
            int n = sc.nextInt();
            if (n > 0) {
                count++;
            }
        }

        System.out.println(count);
    }
}
