package src.beakjoon.bronze;
import java.util.Scanner;

public class Q29790 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int U = sc.nextInt();
        int L = sc.nextInt();

        if (N < 1000) {
            System.out.println("Bad");
        } else if (U >= 8000 || L >= 260) {
            System.out.println("Very Good");
        } else {
            System.out.println("Good");
        }
    }
}
