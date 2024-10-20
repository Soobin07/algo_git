package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q2331 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(A);

		int last = A;
		while (true) {
			int res = mult(last, P);
			if (arr.contains(res)) {
				System.out.println(arr.indexOf(res));
				break;
			}

			arr.add(res);
			last = res;
		}
	}

	public static int mult(int a, int p) {
		int sum = 0;
		while (a > 0) {
			int m = a % 10;
			a /= 10;
			int ret = 1;
			for (int i = 0; i < p; i++) {
				ret *= m;
			}
			sum += ret;
		}
		return sum;
	}
}
