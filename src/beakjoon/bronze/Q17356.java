package src.beakjoon.bronze;
import java.util.Scanner;

public class Q17356 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt(); 
        int B = sc.nextInt(); 

        double M = (B - A) / 400.0;
        double probability = 1.0 / (1.0 + Math.pow(10, M));

        System.out.println(probability);
    }
}
