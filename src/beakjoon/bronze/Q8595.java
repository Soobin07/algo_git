package beakjoon.bronze;

import java.util.Scanner;

public class Q8595 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); 
        sc.nextLine();
        String input = sc.nextLine(); 

        long sum = 0;
        StringBuilder number = new StringBuilder();

        for (char ch : input.toCharArray()) {
            if (Character.isDigit(ch)) {
                number.append(ch);
            } else {
                if (number.length() > 0) { 
                    sum += Long.parseLong(number.toString()); 
                    number.setLength(0); 
                }
            }
        }

        if (number.length() > 0) {
            sum += Long.parseLong(number.toString());
        }

        System.out.println(sum);
	}
}
