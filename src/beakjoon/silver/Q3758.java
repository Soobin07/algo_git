package beakjoon.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//KCPC
public class Q3758 {
	static class Team implements Comparable<Team> {
		int name; // 팀 ID
		int[] score; // 문제 별 점수
		int last; // 마지막 제출
		int sum; // 문제 별 점수 총 합
		int cnt; // 몇번 냈는가

		public Team() {
		}

		public Team(int name, int k) {
			this.name = name;
			this.score = new int[k + 1];
		}

		public void newlog(int last, int q_idx, int q_score) {
			// 가장 마지막 제출 입력
			this.last = last;
			// 제출 횟수 추가
			this.cnt++;
			// 더 큰 점수 올려놓기
			if (score[q_idx] < q_score) {
				sum -= score[q_idx];
				score[q_idx] = q_score;
				sum += score[q_idx];
			}
		}

		@Override
		public int compareTo(Team o) {
			// 점수 비교
			if (this.sum != o.sum)
				return o.sum - this.sum;
			// 풀이 제출 횟수
			if (this.cnt != o.cnt)
				return this.cnt - o.cnt;
			// 마지막 제출 시간 더 빠른 팀
			return this.last - o.last;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = null;

		int TC = Integer.parseInt(br.readLine());
		while (TC-- > 0) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // 팀의 개수
			int k = Integer.parseInt(st.nextToken()); // 문제의 개수
			int t = Integer.parseInt(st.nextToken()); // 내 팀 ID
			int m = Integer.parseInt(st.nextToken()); // 로그 엔트리 개수

			// 팀 초기화
			Team[] arr = new Team[n];
			for (int i = 0; i < n; i++) {
				arr[i] = new Team(i + 1, k);
			}

			// 로그 엔트리 추가
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int id = Integer.parseInt(st.nextToken()); // 팀 번호
				int j = Integer.parseInt(st.nextToken()); // 문제 번호
				int s = Integer.parseInt(st.nextToken()); // 획득 점수

				arr[id - 1].newlog(i, j, s);
			}

			Arrays.sort(arr);

			// 내 팀 찾기
			int grade = 0;
			for (; grade < n; grade++) {
				if (arr[grade].name == t)
					break;
			}

			bw.append((grade + 1) + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
