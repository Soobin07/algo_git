package beakjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q2456 {
	static ArrayList<int[]> arr, big;
	static int sum, idx;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		arr = new ArrayList<>();
		for (int i = 1; i <= 3; i++) {
			arr.add(new int[] { i, 0, 0, 0, 0 }); // idx, 합, 3, 2, 1 갯수
		}

		int N = Integer.parseInt(br.readLine());
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 3; i++) {
				int tmp = Integer.parseInt(st.nextToken());
				arr.get(i)[1] += tmp;
				arr.get(i)[5 - tmp]++; // 앞에서부터 3, 2, 1 만들기 위해
			}
		}

		big = new ArrayList<>();
		// 앞에서부터 비교
		for (int i = 1; i <= 4; i++) {
			sum = 0;
			idx = 0;
			// 비교하는중
			for (int n = 0; n < arr.size(); n++) {
				if (arr.get(n)[i] > sum) {
					big.clear();
					big.add(arr.get(n));
					sum = arr.get(n)[i];
					idx = arr.get(n)[0];
				} else if (arr.get(n)[i] == sum) {
					big.add(arr.get(n));
				}
			}
			// 제일 큰게 하나만 있으면
			if (big.size() == 1) {
				System.out.println(big.get(0)[0] + " " + big.get(0)[1]);
				break;
			}
			if (i == 4) {
				System.out.println("0 " + big.get(0)[1]);
			}
			// 겹치면 다시
			arr.clear();
			arr.addAll(big);
			big.clear();
		}

	}

}
