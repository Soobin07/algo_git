package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q17135 {
	static int N, M, D, ans;
	static ArrayList<int[]> monster;
	static int[] arch;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		monster = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				if (st.nextToken().equals("1"))
					monster.add(new int[] { i, j });
			}
		}

		arch = new int[3];

		pick(0, 0);

		System.out.println(ans);
	}

	// 궁수 3자리 선택
	static void pick(int idx, int sel) {
		if (sel == 3) {
			simulate();
			return;
		}
		for (int i = idx; i <= M; i++) {
			arch[sel] = i;
			pick(idx + 1, sel + 1);
		}
	}

	// 시뮬레이션
	static void simulate() {
		int cnt = 0;
		ArrayList<int[]> tmpList = copy(monster);
		while (true) {
			if (tmpList.isEmpty())
				break;
			ArrayList<int[]> targets = new ArrayList<>();
			for (int k = 0; k < 3; k++) {// 각 궁수마다 잡을 몬스터 설정
				// 잡을 몬스터
				int[] mon = { M + 1, N, 10000 }; // r,c,d
				for (int i = 0; i < tmpList.size(); i++) {
					int[] cur = tmpList.get(i);
					int d = Math.abs(cur[0] - N) + Math.abs(cur[1] - arch[k]);
					if (d <= D) {
						if (mon[2] > d) {
							// 새로운 몬스터가 더 가까움
							mon[0] = cur[0];
							mon[1] = cur[1];
							mon[2] = d;
						} else if (mon[2] == d && mon[1] > cur[1]) {
							// 새로운 몬스터와 기존 몬스터가 같은 거리
							// => 더 왼쪽 친구 가져감
							mon[0] = cur[0];
							mon[1] = cur[1];
							mon[2] = d;
						}
					}
				}

				boolean flag = true;
				for (int i = 0; i < targets.size(); i++) {
					int[] cur = targets.get(i);
					if (mon[0] == cur[0] && mon[1] == cur[1])
						flag = false;
				}
				if (flag)
					targets.add(mon);
			}
			// target에 있는거 제거
			for (int i = 0; i < targets.size(); i++) {
				int[] cur = targets.get(i);
				for (int j = tmpList.size() - 1; j >= 0; j--) {
					int[] tmp = tmpList.get(j);
					if (cur[0] == tmp[0] && cur[1] == tmp[1]) {
						tmpList.remove(j);
						cnt++;
						break;
					}
				}
			}
			for (int i = tmpList.size() - 1; i >= 0; i--) {
				tmpList.get(i)[0] += 1;
				if (tmpList.get(i)[0] == N)
					tmpList.remove(i);
			}
		}
		ans = Math.max(ans, cnt);
	}

	// List 복사
	static ArrayList<int[]> copy(ArrayList<int[]> list) {
		ArrayList<int[]> tmp = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			int[] tmpArr = list.get(i);
			tmp.add(new int[] { tmpArr[0], tmpArr[1] });
		}
		return tmp;
	}
}
