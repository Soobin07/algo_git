package beakjoon.bronze;

import java.util.Scanner;

public class Q1392 {
	public static void main(String[] args) {
		//악보문제. 악보들이 모두 연주되면 걸리는 시간을 구한 후
		//시간별 연주되는 악보를 배열에 담았다.
		//해당 시간에 연주되는 악보를 뽑아내었다.
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int q = sc.nextInt();
		
		int[] akbo = new int[n];
		int sum = 0;
		int[] question = new int[q];
		for(int i = 0 ; i < n ; i++) {
			akbo[i] = sc.nextInt();
			sum += akbo[i];
		}
		for(int i = 0 ; i < q ; i++) {
			question[i] = sc.nextInt();
		}
		
		int[] time = new int[sum];
		sum = 0;
		for(int i = 0 ; i < n ; i++) {
				int limit = sum+akbo[i];
			for(int j = sum ; j < limit ; j++) {
				time[j] = i+1;
				sum++;
			}
		}
		
		for(int i = 0 ; i < question.length ; i++) {
			System.out.println(time[question[i]]);
		}
	}
}
