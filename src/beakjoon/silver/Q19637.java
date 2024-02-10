package beakjoon.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//if문 좀 대신 써줘
public class Q19637 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 칭호의 개수
		int M = Integer.parseInt(st.nextToken()); // 캐릭터 개수

		String[] ching = new String[N]; // 칭호
		int[] stnds = new int[N]; // 기준

		// 칭호 저장
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			ching[i] = st.nextToken();
			stnds[i] = Integer.parseInt(st.nextToken());
		}

		// 각 캐릭터 입력 + 칭호찾기
		for (int i = 0; i < M; i++) {
			int stnd = Integer.parseInt(br.readLine());
			int start = 0;
			int end = N;
			while (start <= end) {
				int mid = (start + end) / 2;
				if (stnds[mid] >= stnd) {
					if (mid - 1 >= 0 && stnds[mid - 1] >= stnd) {
						end = mid - 1;
						continue;
					} else {
						bw.append(ching[mid] + "\n");
						break;
					}
				} else {
					start = mid + 1;
				}
			}
		}
		// 출력
		bw.flush();
		bw.close();
		br.close();
	}
}