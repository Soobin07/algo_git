package beakjoon.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//주식
public class Q11501 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int stnd = 0;
			long diff = 0;
			// stnd (이전 숫자 중 가장 큰 숫자)와 현재 숫자를 비교하여
			for (int i = N - 1; i >= 0; i--) {
				// 이전 숫자가 크거나 같으면
				if (stnd >= arr[i]) {
					// 더 산다 (순익에 더해줌)
					diff += stnd - arr[i];
				} else {
					// 이전 숫자가 더 작으면 기준 바꿔준다
					stnd = arr[i];
				}
			}
			bw.append(diff + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
