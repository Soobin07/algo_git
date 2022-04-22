package beakjoon.bronze;

import java.util.Scanner;

public class Q3985 {
	static String input1 = "10\r\n" + 
			"3\r\n" + 
			"2 4\r\n" + 
			"7 8\r\n" + 
			"6 9";
	static String input2 = "10\r\n" + 
			"3\r\n" + 
			"1 3\r\n" + 
			"5 7\r\n" + 
			"8 9";
	static String input3 = "10\r\n" + 
			"5\r\n" + 
			"1 1\r\n" + 
			"1 2\r\n" + 
			"1 3\r\n" + 
			"1 4\r\n" + 
			"7 8";
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(input3);
		int L = sc.nextInt(); //롤케이크 길이
		int N = sc.nextInt(); //인원수
		int[] cake = new int[L+1];	//케이크(주인)
		int[][] want = new int[N+1][2]; //p, k 
		
		//p,k 입력 & 제일 많이 원하는 사람 확인
		int mostPK = 1;
		for(int i = 1 ; i <= N ; i++) {
			want[i][0] = sc.nextInt(); //p
			want[i][1] = sc.nextInt(); //k
			if(want[mostPK][1]-want[mostPK][0] < want[i][1]-want[i][0]) mostPK = i;
		}
		System.out.println(mostPK);	//방청객 수 1부터 시작
		
		//케이크 배정
		for(int i = 1 ; i <= N ; i++) {
			int p = want[i][0];
			int k = want[i][1];
			for(int j = p ; j <= k ; j++) {
				if(cake[j] == 0) cake[j] = i;
			}
		}
		
		//n번 사람이 케이크 받은 수 카운트
		int[] count = new int[N+1];
		for(int i = 1 ; i <= L ; i++) {
			count[cake[i]]++;
		}
		
		int mostL = 1;	//아무도 못받은 것이 0에 들어있다. 0이 가장 클 수있으니 idx인 mostL을 사람 시작 1부터 시작
		for(int i = 1 ; i <= N ; i++) {
			if(count[i] > count[mostL]) mostL = i;
		}
		System.out.println(mostL);
	}
}
