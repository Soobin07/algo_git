package beakjoon.silver;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Q16922 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[] arr = { 1, 5, 10, 50 };
		Set<Integer> visit = new HashSet<>();

		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= N; j++) {
				if (i + j > N)
					break;
				for (int k = 0; k <= N; k++) {
					if (i + j + k > N)
						break;

					for (int l = 0; l <= N; l++) {
						if (i + j + k + l > N)
							break;
						if (i + j + k + l == N) {
							int tmp = arr[0] * i + arr[1] * j + arr[2] * k + arr[3] * l;
							if (!visit.contains(tmp)) {
								visit.add(tmp);
							}
						}
					}
				}
			}
		}
		System.out.println(visit.size());
	}
}
