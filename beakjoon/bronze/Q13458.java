package beakjoon.bronze;

import java.util.Scanner;

//ceil 올림 floor 내림 round 반올림
public class Q13458 {
	static String input1 = "1\r\n" + 
			"1\r\n" + 
			"1 1";	//1
	static String input2 = "3\r\n" + 
			"3 4 5\r\n" + 
			"2 2";	//7
	static String input3 = "5\r\n" + 
			"1000000 1000000 1000000 1000000 1000000\r\n" + 
			"5 7";	//714290
	static String input4 = "5\r\n" + 
			"10 9 10 9 10\r\n" + 
			"7 20";	//10
	static String input5 = "5\r\n" + 
			"10 9 10 9 10\r\n" + 
			"7 2";	//13
	static String input6 = "8\r\n" + 
			"5 10 30 235 1 23 24 101\r\n" + 
			"10 3";	//127
	static String input7 = "5\r\n" + 
			"1 1 1 1 1\r\n" + 
			"4 1";	//5
	public static void main(String[] args) {
		Scanner sc = new Scanner(input6);
//		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] A = new int[N];

		for(int i = 0 ; i < N ; i++) {
			A[i] = sc.nextInt();
		}
		
		int B = sc.nextInt();
		double C = sc.nextDouble();
		
		long cnt = 0;
		for(int i = 0 ;i < N ; i++) {
			int a = A[i] - B;
			cnt++;	//총감독관
			cnt += Math.max(Math.ceil(a/C), 0);
		}
		System.out.println(cnt);
	}
}
