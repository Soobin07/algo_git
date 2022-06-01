package beakjoon.silver;

import java.util.Scanner;

public class Q1057 {
	static String input1 = "16 1 2"; //1
	static String input2 = "16 8 9"; //4
	static String input3 = "1000 20 31"; //4
	static String input4 = "65536 1000 35000"; //16
	static String input5 = "60000 101 891"; //10
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(input5);
		int N = sc.nextInt();
		int kimNo = sc.nextInt();
		int imNo = sc.nextInt();
		int cnt = 0;
		
		while(true) {
			cnt++;
			kimNo = (kimNo+1)/2;
			imNo = (imNo+1)/2;
			if(kimNo == imNo) break;
		}
		System.out.println(cnt);
	}
	
}
