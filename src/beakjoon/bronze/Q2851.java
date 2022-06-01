package beakjoon.bronze;

import java.util.Scanner;

public class Q2851 {
	static String input1 = "10\r\n" + 
			"20\r\n" + 
			"30\r\n" + 
			"40\r\n" + 
			"50\r\n" + 
			"60\r\n" + 
			"70\r\n" + 
			"80\r\n" + 
			"90\r\n" + 
			"100";	//100
	static String input2 = "1\r\n" + 
			"2\r\n" + 
			"3\r\n" + 
			"5\r\n" + 
			"8\r\n" + 
			"13\r\n" + 
			"21\r\n" + 
			"34\r\n" + 
			"55\r\n" + 
			"89";	//87
	static String input3 = "40\r\n" + 
			"40\r\n" + 
			"40\r\n" + 
			"40\r\n" + 
			"40\r\n" + 
			"40\r\n" + 
			"40\r\n" + 
			"40\r\n" + 
			"40\r\n" + 
			"40";	//120
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(input3);
		
		int[] scores = new int[10];
		int over100Idx = -1;
		int over_sum = 0;
		for(int i = 0 ; i < 10 ; i++) {
			scores[i] = sc.nextInt();
			over_sum += scores[i];
			if(over_sum >= 100) {
				over100Idx = i;
				break;
			}
		}
		if(over100Idx > 0 && Math.abs(100-over_sum) > Math.abs(100-(over_sum-scores[over100Idx]))) over_sum -=scores[over100Idx];
		System.out.println(over_sum);
	}
}
