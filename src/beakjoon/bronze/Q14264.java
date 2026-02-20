package src.beakjoon.bronze;
import java.util.Scanner;

public class Q14264 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double L = sc.nextDouble();
        sc.close();
        
        double area = (Math.sqrt(3) / 4) * L * L;
        System.out.println(area);
    }
}
