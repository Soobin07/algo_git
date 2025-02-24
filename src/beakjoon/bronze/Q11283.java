package beakjoon.bronze;

import java.util.Scanner;

public class Q11283 {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);

        String input = sc.next();
        char ch = input.charAt(0);
        
        int index = ch - '가' + 1;
        
        System.out.println(index);
    }
}