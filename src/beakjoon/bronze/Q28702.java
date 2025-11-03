package src.beakjoon.bronze;

import java.util.*;

public class Q28702 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = new String[3];
        for (int i = 0; i < 3; i++) arr[i] = sc.nextLine();
        
        int num = 0;
        int idx = 0;
        
        for (int i = 0; i < 3; i++) {
            try {
                num = Integer.parseInt(arr[i]);
                idx = i;
                break;
            } catch (NumberFormatException e) {}
        }
        int next = num + (3 - idx);

        if (next % 15 == 0) System.out.println("FizzBuzz");
        else if (next % 3 == 0) System.out.println("Fizz");
        else if (next % 5 == 0) System.out.println("Buzz");
        else System.out.println(next);
    }
}
