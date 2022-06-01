package beakjoon.bronze;

import java.util.Scanner;

public class Q2798 {
	//1. 배열의 값을 중복없이 한번씩만 사용하여 depth = 3까지 무조건 내려간다
	//2. 사용한 배열의 값을 더한다.
	//3. Math.abs(더한 값-m)이 더 작은 수를 sum에 놓는다
	//재귀함수 만드는 방법 재사용해보자
	
	
	static int[] arr;		//카드 배열
	static boolean[] visit; //해당 index값 사용 여부
	static int sum = 0; 		//카드 3장의 합 
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int n = sc.nextInt();	//카드 갯수
		int m = sc.nextInt();	//합의 기준수
		
		arr = new int[n];
		visit = new boolean[n];
		
		
		//카드 배열을 받는다
		for(int i = 0 ; i < n ; i++) {
			arr[i] = sc.nextInt();
		}
		
		//재귀함수를 통해 m과 가장 가까운 sum을 구한다
		search(n,m,0);
		
		System.out.println(sum);
	}
	static void search(int n, int m, int count) {
		if(count == 3) {
			int sum2 = 0;
			for(int i = 0 ; i < n ; i++) {
				if(visit[i] == true) {
					sum2 += arr[i];
				}
			}
			if(sum2 <= m && Math.abs(sum - m) > Math.abs(sum2 - m)) {
				sum = sum2;
			}
			return;
		}
		
		for(int i = 0 ; i < n ; i++) {
			if(arr[i] > m) return;
			if(visit[i] == false) {
				visit[i] = true;
				
				search(n, m, count+1);
				
				visit[i] = false;
			}
		}
		return;
	}
}
