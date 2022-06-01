package beakjoon.silver;

import java.util.Scanner;

public class Q14501 {
	static String input1 = "7\r\n" + 
			"3 10\r\n" + 
			"5 20\r\n" + 
			"1 10\r\n" + 
			"1 20\r\n" + 
			"2 15\r\n" + 
			"4 40\r\n" + 
			"2 200";	//45
	static String input2 = "10\r\n" + 
			"1 1\r\n" + 
			"1 2\r\n" + 
			"1 3\r\n" + 
			"1 4\r\n" + 
			"1 5\r\n" + 
			"1 6\r\n" + 
			"1 7\r\n" + 
			"1 8\r\n" + 
			"1 9\r\n" + 
			"1 10";		//55
	static String input3 ="10\r\n" + 
			"5 10\r\n" + 
			"5 9\r\n" + 
			"5 8\r\n" + 
			"5 7\r\n" + 
			"5 6\r\n" + 
			"5 10\r\n" + 
			"5 9\r\n" + 
			"5 8\r\n" + 
			"5 7\r\n" + 
			"5 6";		//20
	static String input4 ="10\r\n" + 
			"5 50\r\n" + 
			"4 40\r\n" + 
			"3 30\r\n" + 
			"2 20\r\n" + 
			"1 10\r\n" + 
			"1 10\r\n" + 
			"2 20\r\n" + 
			"3 30\r\n" + 
			"4 40\r\n" + 
			"5 50";		//90
	
	static int max_pay = 0;
	static int[][] tp;
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(input2);
	
		int N = sc.nextInt();
		tp = new int[N][2];
		for(int i = 0 ; i < N ; i++) {
			tp[i][0] = sc.nextInt();
			tp[i][1] = sc.nextInt();
		}
		
		findMaxP(0,0,N,0);
		
		System.out.println(max_pay);
	}
	static void findMaxP(int index, int sumP, int N , int resT) {
		if(index >= N) {
			max_pay = Math.max(sumP, max_pay);
			return;
		}
		
		//선택X
		findMaxP(index+1, sumP, N, Math.max(resT-1, 0));
		//선택O
		if(N-index >= tp[index][0] && resT == 0) {
			findMaxP(index+1, sumP+tp[index][1], N, resT+tp[index][0]-1);
		}
		
	}
}
