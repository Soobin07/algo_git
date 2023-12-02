package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1043 {
	static int N, M, ans;
	static int[][] party;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 조건 받기
		N = Integer.parseInt(st.nextToken()); // 사람 수
		M = Integer.parseInt(st.nextToken()); // 파티의 수

		boolean[][] party = new boolean[N + 1][M + 1]; // 그 사람이 그 파티에 감?
		int[][] map = new int[N + 1][M + 1]; // [0]_ : 해당 파티에서 과장했나? / _[0] : 해당 사람이 진실 알고 있나

		Queue<Integer> know = new LinkedList<>();

		// 아는 사람에 넣기
		st = new StringTokenizer(br.readLine());
		int kc = Integer.parseInt(st.nextToken());
		for (int i = 0; i < kc; i++) {
			know.add(Integer.parseInt(st.nextToken()));
		}

		// 파티 가는 사람 체크
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int tmp = Integer.parseInt(st.nextToken());
			for (int j = 0; j < tmp; j++) {
				party[Integer.parseInt(st.nextToken())][i] = true;
			}
		}

		// 1 : 진실 알고있다
		while (!know.isEmpty()) {
			int p_num = know.poll();
			// 이미 처리함
			if (map[p_num][0] == 1) {
				continue;
			} else {
				map[p_num][0] = 1; // 이 사람이 진실 알고 있음
				// 어느 파티에 가나?
				for (int i = 1; i <= M; i++) {
					// 이 파티에는 감 => 해당 파티 처리하기 (아직 처리되지 않은 파티일 경우에만)
					if (party[p_num][i] && !party[0][i]) {
						party[0][i] = true; // 파티에서 진실 말함

						// 같은 파티 있던 사람들 전부 넣어주자
						for (int j = 1; j <= N; j++) {
							// 중복 최소화
							if (party[j][i] && !know.contains(j) && map[j][0] != 1) {
								know.add(j);
							}
						}
					}
				}
			}
		}
		
		// 진실 말하지 않음 => 과장
		int cnt = 0;
		for(int i = 1 ; i <= M ; i++) {
			if(!party[0][i]) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}
