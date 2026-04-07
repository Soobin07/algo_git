package src.beakjoon.bronze;
import java.util.Scanner;

public class Q27736 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int agree = 0;  
        int disagree = 0; 
        int abstain = 0; 

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();

            if (x == 1) agree++;
            else if (x == -1) disagree++;
            else abstain++;
        }

        if (abstain * 2 >= n) {
            System.out.println("INVALID");
        }
        else if (agree > disagree) {
            System.out.println("APPROVED");
        }
        else {
            System.out.println("REJECTED");
        }

        sc.close();
    }
}
