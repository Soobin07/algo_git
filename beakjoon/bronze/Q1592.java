package beakjoon.bronze;

import java.util.Scanner;

public class Q1592 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	//사람 수
		int M = sc.nextInt();	//끝나는 조건 (가장 많이 공을 받은 사람이 공을 받은 횟수)
		int L = sc.nextInt();	//몇번째 사람에게 주나 (거리)
		
		int[] arr = new int[N];	//N번째 사람이 받은 횟수가 N-1에 들어가있다
		
		int count = 0;	//던진 횟수
		int d = 0;      //현재 공을 가진 사람 번호
		int max = 0;    //현재 공을 가장 많이 받은 사람
		
		while(true) {	//무한반복
			if(arr[d]%2 == 0) {	//공을 받은 사람이 공을 받은 횟수가 짝수번
				d += L;
				if(d >= N) d -= N;	
			}else {	//홀수번
				d -= L;
				if(d < 0) d += N;
			}
			arr[d]++;
			if(max < arr[d]) max = arr[d];
			if(max == M) break;	//max가 조건을 만족하면 무한반복 탈출
			count++;
		}
		System.out.println(count);
	}
}
