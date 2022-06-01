package beakjoon.bronze;

import java.util.Scanner;

public class Q10834 {
	static String input1 = "3\r\n" + 
			"1 2 0\r\n" + 
			"1 5 1\r\n" + 
			"2 1 0";	//1 5
	static String input2 = "4\r\n" + 
			"1 10 1\r\n" + 
			"2 1 1\r\n" + 
			"5 6 0\r\n" + 
			"3 2 0";	//0 4
	static String input3 = "2\r\n" + 
			"1 49 0\r\n" + 
			"49 1 0";	//0 1
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(input3);
		
		int turn = 0;
		double cnt = 1d;
		int M = sc.nextInt();
		for(int i = 0 ; i < M ; i++) {
			int val1 = sc.nextInt();
			int val2 = sc.nextInt();
			cnt = cnt*val2/val1;
			
			int val3 = sc.nextInt();
			if(val3 == 1) {
				if(turn == 1)
					turn = 0;
				else turn = 1;
			}
		}
		
		System.out.println(turn+" "+(int)cnt);
	}
}
