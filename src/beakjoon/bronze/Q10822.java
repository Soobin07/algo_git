package beakjoon.bronze;

import java.util.Scanner;

public class Q10822 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long sum = 0L;
		String str = sc.next();
		String[] arr = str.split(",");
		for(String s : arr) {
			sum += Long.parseLong(s);
		}
		
		System.out.println(sum);
	}
}
