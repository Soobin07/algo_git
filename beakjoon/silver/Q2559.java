package beakjoon.silver;

import java.util.Scanner;

//주의!!! 제시되는 값에 음수가 들어있으면, max 값이 음수가 나올수도 있다!!!
//주의!!! 제시되는 값에 음수가 들어있으면, max 값이 음수가 나올수도 있다!!!
//주의!!! 제시되는 값에 음수가 들어있으면, max 값이 음수가 나올수도 있다!!!
//주의!!! 제시되는 값에 음수가 들어있으면, max 값이 음수가 나올수도 있다!!!
//주의!!! 제시되는 값에 음수가 들어있으면, max 값이 음수가 나올수도 있다!!!

public class Q2559 {
	
	static String input1 = "10 2\r\n" + 
			"3 -2 -4 -9 0 3 7 13 8 -3";	//21
	
	static String input2 = "10 5\r\n" + 
			"3 -2 -4 -9 0 3 7 13 8 -3";	//31
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[] arr = new int[N];
		for(int i = 0 ; i < N ; i++) {
			arr[i] = sc.nextInt();
		}
		
		int max = Integer.MIN_VALUE;	//주의!!! 제시되는 값에 음수가 들어있으면, max 값이 음수가 나올수도 있다!!!
		
		for(int i = 0 ; i < N-K+1 ; i++) {
			int sum = 0;
			for(int j = 0 ; j < K ; j++) {
				sum += arr[i+j]; 
			}
			max = Math.max(max, sum);
		}
		System.out.println(max);
		
		
		
		//2. 시간을 줄이는 다른 방법 O(1) wldbs1120
		//https://www.acmicpc.net/source/22812453
		// 처음 수 부터 k개를 더한다. 그 후, 가장 앞은 빼주고, 뒤는 더해준다. 그러면서 max를 찾는다.
		// 두번째, 세번째로..같은게 필요하면 이 수들을 배열에 넣을 수가 있겠다. exponential_e
		//https://www.acmicpc.net/source/10021734
		/*
			int sum = 0;
			for (int i = 0; i < K; i++) {
				sum += numArr[i];
			}
	
			int pub = sum;
			for (int j = K; j < N; j++) {
				pub += numArr[j];
				pub -= numArr[j - K];
				sum = sum > pub ? sum : pub;
			}
	
			System.out.println(sum);
		*/
	}
}
