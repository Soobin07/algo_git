package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q9440 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		String line = null;
		while ((line = br.readLine()).charAt(0) != '0') {
			st = new StringTokenizer(line);
			int N = Integer.parseInt(st.nextToken());

			if (N == 0)
				break;

			int sum = 0;
			int cntZero = 0;

			Integer[] arr = new Integer[N];
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				if (arr[i] == 0)
					cntZero++;
			}

			Arrays.sort(arr);

			if(cntZero > 0) {
				for (int i = 0; i < 2; i++) {
					arr[i] = arr[cntZero+i];
					arr[cntZero+i] = 0;
				}
			}
			
			int pow = 0;
			for (int i = 0; i < N; i++) {
				sum += arr[N-1 - i] * Math.pow(10, pow);
				if (i % 2 == 1)
					pow++;
			}

			sb.append(sum).append("\n");
		}
		System.out.print(sb.toString());
	}
}
