package src.beakjoon.bronze;
import java.util.Scanner;

public class Q14623 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String b1 = sc.nextLine();
        String b2 = sc.nextLine();
        
        long num1 = Long.parseLong(b1, 2);
        long num2 = Long.parseLong(b2, 2);
        
        long result = num1 * num2;
        
        String resultBinary = Long.toBinaryString(result);
        
        System.out.println(resultBinary);
    }
}
