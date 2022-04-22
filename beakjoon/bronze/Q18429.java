package beakjoon.bronze;

import java.util.Scanner;

public class Q18429 {
	static String input1 = "3 4\r\n" + 
			"3 7 5";
	
	static int[] arr;
	static boolean[] arr_visit;
	static int count;
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(input1);
		
		int weight = 500;
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		count = 0;
		
		arr = new int[N];
		arr_visit = new boolean[N];
		
		for(int i = 0 ; i < N ; i++) {
			arr[i] = sc.nextInt();
		}
		find(0, weight, K);
		
		System.out.println(count);
	}
	
	static void find(int index, int weight, int K) {
		if(weight < 500) return;
		if(index == arr.length) {
			count++;
			return;
		}
		for(int i = 0 ; i < arr.length ; i++) {
			if(!arr_visit[i]) {
				arr_visit[i] = true;
				find(index+1, weight+arr[i]-K, K);
				arr_visit[i] = false;
			}
		}
	}
}
