package beakjoon.bronze;

import java.util.Scanner;

public class Q2798_2 {
	static String input1 = "5 21\r\n" + 
			"5 6 7 8 9";
	static String input2 = "10 500\r\n" + 
			"93 181 245 214 315 36 185 138 216 295";
	static String input3 = "4 10\r\n" + 
			"1 2 3 10";	//답 6
	
	static int answer = Integer.MAX_VALUE; 		//카드 3장의 합 (가장 가까운 값)
	public static void main(String[] args) {
//		Scanner sc= new Scanner(System.in);
		Scanner sc= new Scanner(input2);
		
		int n = sc.nextInt();	//카드 갯수
		int m = sc.nextInt();	//합의 기준수
		
		int[] arr = new int[n];	//카드 배열
		
		//카드 배열을 받는다
		for(int i = 0 ; i < n ; i++) {
			arr[i] = sc.nextInt();
		}
		
		//재귀함수를 통해 m과 가장 가까운 sum을 구한다
		search(arr, 0, m, 0, 0);
		
		System.out.println(answer);
	}
	
	//카드 배열, 배열 인덱스, 합 기준수, 카드 몇개 뽑음?, 합
	static void search(int[] arr, int idx, int m, int count, int sum) {
		if(count == 3 && sum <= m) {	//성공조건(m값을 넘지 않으면서 
			answer = Math.abs(m-answer) > Math.abs(m-sum) ? sum : answer;
			return;
		}
		if(sum > m || idx == arr.length) return;	//실패(m값 넘음, 배열 끝까지 갔는데 3개 안더함)
		
		//해당 인덱스 안뽑음
		search(arr, idx+1, m, count, sum);
		//해당 인덱스 뽑음
		search(arr, idx+1, m, count+1, sum+arr[idx]);
		
	}
}
