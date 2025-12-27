package src.beakjoon.bronze;
import java.util.Scanner;

public class Q32962 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int X = sc.nextInt();

        int maxS = -1;  

   
        for (int i = 0; i < N; i++) {
            int S = sc.nextInt();  
            int T = sc.nextInt();  

         
            if (S + T <= X) {
                maxS = Math.max(maxS, S);  
            }
        }

        if (maxS == -1) {
            System.out.println(-1);
        } else {
            System.out.println(maxS);  
        }

        sc.close();
    }
}
