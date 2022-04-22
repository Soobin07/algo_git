package beakjoon.bronze;

import java.util.Scanner;

//시간초과
public class Q12865 {
	static int[][] object;
	static int max_value = 0;
	static boolean[] visit;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();			//물건의 갯수
		int k = sc.nextInt();			//버틸 수 있는 무게
		object = new int[n][2];			//물건[무게,가치]
		
		visit = new boolean[n];			
		
		//물건 무게, 가치
		for(int i = 0 ; i < n ; i++) {
			object[i][0] = sc.nextInt();
			object[i][1] = sc.nextInt();
		}
		
		sum(n,k,0,0);
		
		System.out.println(max_value);
	}
	static void sum(int n, int k, int weight, int value) {
		if(weight > k) return;
		else 
			if(max_value < value) max_value = value;
		//1. 물건 무게 합 <= k일 때의 v를 구함
		//2. v의 최대값을 구함
		for(int i = 0 ; i < n ; i++) {
			if(visit[i] == false) {
				visit[i] = true;
				sum(n,k,weight+object[i][0], value+object[i][1]);
				visit[i] = false;
			}
		}
	}
}
