package src.beakjoon.bronze;
import java.util.Scanner;

public class Q15667 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt(); 
        sc.close();

        int K = 0;
        while(true) {
            int total = 1 + K + K * K;
            
            if(total == N) {
                System.out.println(K);
                break;
            }
            K++;
        }
    }
}
