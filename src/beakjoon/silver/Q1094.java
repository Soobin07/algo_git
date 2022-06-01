package beakjoon.silver;

import java.util.Scanner;

public class Q1094 {
	static String input1 = "23";	//4
	static String input2 = "32";	//1
	static String input3 = "64";	//1
	static String input4 = "48";	//2
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(input1);
		
		int X = sc.nextInt();
		char[] binary = Integer.toBinaryString(X).toCharArray();
		
		int cnt = 0;
		for(int i = 0 ; i < binary.length ; i++) {
			char ch = binary[i];
			if(ch == 1+'0') cnt++;
		}
		System.out.println(cnt);
	}
}
