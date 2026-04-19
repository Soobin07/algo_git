package src.beakjoon.bronze;
import java.util.Scanner;

public class Q21312 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int resultOdd = 1;
        int resultAll = 1;
        boolean hasOdd = false;

        for (int i = 0; i < 3; i++) {
            int x = sc.nextInt();

            if (x % 2 == 1) { 
                resultOdd *= x;
                hasOdd = true;
            }

            resultAll *= x; 
        }

        if (hasOdd) {
            System.out.println(resultOdd);
        } else {
            System.out.println(resultAll);
        }
    }
}
