package beakjoon.bronze;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Q25305 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int k = sc.nextInt();

		Integer[] arr = new Integer[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2 - o1;
			}
		});

		System.out.println(arr[k - 1]);
	}
}
