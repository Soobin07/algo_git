package beakjoon.bronze;

import java.util.Arrays;
import java.util.Scanner;

public class Q9076 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0 ; t < T ; t++) {			
			int[] arr = new int[5];
			for (int i = 0 ; i < 5 ; i++) {
				arr[i] = sc.nextInt();
			}
			Arrays.sort(arr);
			if( arr[3] - arr[1] >= 4) {
				System.out.println("KIN");
			}else {
				int sum = 0;
				for(int k = 1 ; k <= 3 ; k++) {
					sum += arr[k];
				}
				System.out.println(sum);
			}
		}
	}
}
