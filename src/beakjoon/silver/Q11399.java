package beakjoon.silver;

import java.util.Arrays;
import java.util.Scanner;

public class Q11399 {
	static String input1 = "5\r\n" + 
			"3 1 4 3 2"; //32
	
	public static void main(String[] args) {
//		Scanner sc = new Scanner(input1);
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] line = new int[N];
		
		for(int i = 0 ; i < N ; i++) {
			line[i] = sc.nextInt();
		}
		
		Arrays.sort(line);
		
		int sum = 0;
		for(int i = 0 ; i < N ; i++) {
			sum += (N-i)*line[i];
		}
		System.out.println(sum);
	}
}
