package beakjoon.silver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Q11576 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();

		int m = sc.nextInt();
		int[] arr = new int[m];
		for (int i = 0; i < m; i++) {
			arr[i] = sc.nextInt();
		}

		int sum = 0;
		for (int i = 0; i < m; i++) {
			sum += arr[i] * Math.pow(A, arr.length - 1 - i);
		}

		List<Integer> res = new ArrayList<>();
		while (sum > 0) {
			res.add(sum % B);
			sum /= B;
		}

		Collections.reverse(res);
		for (int i = 0; i < res.size(); i++) {
			System.out.print(res.get(i) + " ");
		}
	}
}
