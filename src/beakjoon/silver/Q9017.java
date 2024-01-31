package beakjoon.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

//크로스컨트리
public class Q9017 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		// 테스트케이스
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			// 선수 숫자
			int N = Integer.parseInt(br.readLine());
			// 팀과 팀원 숫자
			HashMap<Integer, Integer> teams = new HashMap<>();
			// 들어온 순서 (팀 명으로 표기)
			int[] order = new int[N + 1];

			st = new StringTokenizer(br.readLine());
			// 선수 넣기
			for (int i = 1; i <= N; i++) {
				// 어느 팀이야?
				int team = Integer.parseInt(st.nextToken());
				// 등록 안된 팀이면 등록하고 팀원 수 넣어줘
				teams.putIfAbsent(team, 0);
				teams.replace(team, teams.get(team) + 1);
				order[i] = team;
			}

			// 6명 안되는 팀은 제거하기
			ArrayList<Integer> remove_team = new ArrayList<>();
			for (int team : teams.keySet()) {
				if (teams.get(team) < 6) {
					remove_team.add(team);
				}
			}
			for (int team : remove_team) {
				teams.remove(team);
			}

			// 실격 제외하고 순위 다시 구하기
			HashMap<Integer, ArrayList<Integer>> re_order = new HashMap<>();
			int new_order = 1;
			for (int i = 1; i <= N; i++) {
				int team = order[i];
				// 6명 채운 팀이면 순위 다시 넣어준다
				if (teams.containsKey(team)) {
					re_order.putIfAbsent(team, new ArrayList<Integer>());
					re_order.get(team).add(new_order++);
				}
			}

			// 남은 팀 순위를 각 팀의 4위까지 더해서 스코어 정하기
			teams.clear();
			for (int team : re_order.keySet()) {
				int sum = 0;
				ArrayList<Integer> tmp_order = re_order.get(team);
				for (int i = 0; i < 4; i++) {
					sum += tmp_order.get(i);
				}
				teams.put(team, sum);
			}

			// 점수 확인
			int min_score = Integer.MAX_VALUE;
			ArrayList<Integer> ms_team = new ArrayList<>();
			for (int team : teams.keySet()) {
				int score = teams.get(team);
				// 가장 작은 점수 발견
				if (min_score > score) {
					// 가장 작은 점수 바꿔주고
					min_score = score;
					ms_team.clear();
					// 가장 작은 점수 가진 팀 초기화 후 다시 넣어주기
					ms_team.add(team);
				} else if (min_score == score) {
					// 같은 점수가 있을 때는 이 팀도 넣어주기
					ms_team.add(team);
				}
			}

			// 가장 낮은 점수 팀이 하나만 있으면 그것을 출력
			if (ms_team.size() == 1) {
				bw.append(ms_team.get(0) + "\n");
			} else {
				// 점수 같은 팀이 여러 팀이면 팀에서 5등이 먼저 들어온 팀 확인
				int ans_team = 0;
				min_score = Integer.MAX_VALUE;
				for (int team : ms_team) {
					ArrayList<Integer> teammate = re_order.get(team);
					Collections.sort(teammate);
					int f_th = teammate.get(4);
					if (min_score > f_th) {
						min_score = f_th;
						ans_team = team;
					}
				}
				bw.append(ans_team + "\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
