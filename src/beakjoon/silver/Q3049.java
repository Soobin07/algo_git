package beakjoon.silver;

import java.util.Scanner;

public class Q3049 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long result = (long) n * (n - 1) * (n - 2) * (n - 3) / 24;
        System.out.println(result);
    }
}
