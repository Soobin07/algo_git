package beakjoon.bronze;

import java.util.Arrays;
import java.util.Scanner;

public class Q2587 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//평균과 중앙값 구하기
		int N = 5;
		
		int[] arr = new int[N];
		int avr = 0;
		for(int i = 0 ; i < N ; i++) {
			arr[i] = sc.nextInt();
			avr += arr[i];
		}
		
		Arrays.sort(arr);
		avr /= N;
		System.out.println(avr);
		System.out.println(arr[2]);
	}
}
