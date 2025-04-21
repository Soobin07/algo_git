package beakjoon.silver;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Q2535 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N][3];
		for (int i = 0; i < N; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
			arr[i][2] = sc.nextInt();
		}

		Arrays.sort(arr, (o1, o2) -> {
			return o2[2] - o1[2];
		});

		HashMap<Integer, Integer> vi = new HashMap();
		int cnt = 0;
		int idx = 0;
		StringBuffer sb = new StringBuffer();
		while (cnt < 3) {
			int[] now = arr[idx++];
			if (vi.containsKey(now[0]) && vi.get(now[0]) >= 2) {
				continue;
			}
			sb.append(now[0] + " " + now[1] + "\n");
			cnt++;
			if (vi.containsKey(now[0])) {
				vi.replace(now[0], vi.get(now[0]) + 1);
			} else {
				vi.put(now[0], 1);
			}
		}
		System.out.println(sb.toString());
	}
}
