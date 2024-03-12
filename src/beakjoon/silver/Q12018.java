package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//Yonsei TOTO
public class Q12018 {
	public static void main(String[] args) throws Exception {
		// 듣고 싶은 과목에 마일리지 1~36 분배
		// 주어진 마일리지로 최대한 많은 과목 신청
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 과목수 n <= 100 , 마일리지 m <= 100
		int N = Integer.parseInt(st.nextToken()); // 과목수
		int M = Integer.parseInt(st.nextToken()); // 마일리지

		// 각 과목마다 2줄의 입력
		// 1. 각 과목에 신청한 사람 수 p <= 100 , 과목의 수강인원 L <=100
		// 2. 각 사람이 마일리지를 얼마나 넣었는지
		// 마일리지가 같다면 성준이에게 우선순위

		// => 각 과목의 커트라인 사람과 같은 마일리지를 넣으면 된다
		// ANS : 첫째 줄에 주어진 마일리지로 들을 수 있는 최대 과목 개수

		int[][] clas = new int[N][2]; // 각 과목 신청한 사람 수, 수강인원
		Integer[][] mile = new Integer[N][]; // 각 과목에서, 각 사람이 넣은 마일리지
		PriorityQueue<Integer> pq = new PriorityQueue<>(); // 각 과목 커트라인 마일리지를 작은 것 부터
		int ans = 0; // 수강신청 성공한 과목 갯수

		// 첫번째 과목부터 돌면서 입력 + 막차 마일리지 찾기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			clas[i][0] = Integer.parseInt(st.nextToken()); // 신청한 사람 수
			clas[i][1] = Integer.parseInt(st.nextToken()); // 과목의 수강 인원

			// 신청한 사람 수가 수강 인원 보다 크거나 같을 때 (경쟁이 필요함)
			if (clas[i][0] >= clas[i][1]) {
				mile[i] = new Integer[clas[i][0]];
				st = new StringTokenizer(br.readLine());
				// 각 사람이 마일리지를 얼마나 넣었나
				for (int j = 0; j < clas[i][0]; j++) {
					mile[i][j] = Integer.parseInt(st.nextToken());
				}

				// 정렬
				Arrays.sort(mile[i], Collections.reverseOrder());

				// 막차 마일리지
				pq.add(mile[i][clas[i][1] - 1]);
			} else {
				// 수강인원 부족! 1만 넣어도 들어갈 수 있음
				st = new StringTokenizer(br.readLine());
				// 마일리지가 있으면 계속 신청하자
				if (M <= 0)
					continue;
				M--;
				ans++;
			}
		}

		// 작은 것 부터 빼면서 최대한 마일리지 사용하기
		while (!pq.isEmpty()) {
			// 가장 작은 마일리지가 필요한 과목(의 마일리지)
			int now = pq.poll();
			// 현재 과목 신청할 수 없는 경우 => 앞으로 모두 취소
			if (M - now < 0)
				break;

			M -= now;
			ans++;
		}

		System.out.println(ans);
	}

	// 아래는 정확하게 구할 수 있지만 시간초과가 난다. 조금 더 간단한 방법을 구해야 한다.
	/*
	 * // 각 과목 막차 마일리지를 돌면서 M과 차이가 가장 적은 합 구하기 static void find(int idx, int sel,
	 * int sum) { // 마지막 과목을 지나갔을 때 확인 후 종료 if (idx >= N) { // 모든 과목을 신청할 수 있을 때 if
	 * (sum <= M) { ans = Math.max(sel, ans); } return; } // sum이 M을 지나갔을 때 종료 if
	 * (sum > M) { return; }
	 * 
	 * find(idx + 1, sel, sum); find(idx + 1, sel + 1, sum + last[idx]); }
	 */}
