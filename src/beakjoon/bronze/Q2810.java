package beakjoon.bronze;

import java.util.Scanner;

public class Q2810 {
	static String input1="3\r\n" + 
			"SSS";
	static String input2= "4\r\n" + 
			"SLLS";
	static String input3 = "9\r\n" + 
			"SLLLLSSLL";
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(input3);
		
		int count = 1;	//제일 좌측에 하나 있다. (여기서부터 시작~)
		int N = sc.nextInt();
		String line = sc.next();
		for(int i = 0 ; i < N ; i++) {
			if(line.charAt(i)=='S') count++;
			else {
				count++;
				i++;
			}
		}
		System.out.println(Math.min(count, N));
	}
}
