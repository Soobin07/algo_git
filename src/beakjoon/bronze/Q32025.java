package src.beakjoon.bronze;
import java.util.Scanner;

public class Q32025 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int H = sc.nextInt();
        int W = sc.nextInt();

        int result = Math.min(H, W) * 50;

        System.out.println(result);
    }
}
