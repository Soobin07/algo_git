package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//상범빌딩
public class Q6593_2 {
	static int L, R, C; // 층, 행, 열
	static char[][][] building = new char[31][31][31]; // 빌딩 모양
	static int[] start = new int[3];
	static int[] end = new int[3];

	static int[][] dir = new int[6][3];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		// dir 설정 동서남북상하
		dir[0] = new int[] { 0, 0, -1 };
		dir[1] = new int[] { 0, 0, 1 };
		dir[2] = new int[] { 0, 1, 0 };
		dir[3] = new int[] { 0, -1, 0 };
		dir[4] = new int[] { -1, 0, 0 };
		dir[5] = new int[] { 1, 0, 0 };

		// testcase 돌리기
		testcase: while (insertBuilding(st, br.readLine())) {
			// 건물 해당 칸에 갈 수 있는지 받아서 넣기
			for (int l = 1; l <= L; l++) {
				for (int r = 1; r <= R; r++) {
					String tmp = br.readLine();
					for (int c = 1; c <= C; c++) {
						building[l][r][c] = tmp.charAt(c - 1);
						// start인가
						if (tmp.charAt(c - 1) == 'S') {
							start[0] = l;
							start[1] = r;
							start[2] = c;
						} else if (tmp.charAt(c - 1) == 'E') {
							// end인가
							end[0] = l;
							end[1] = r;
							end[2] = c;
						}
					}
				}
				br.readLine(); // 한 층이 끝나면 빈 줄 하나
			}

			// 시작부터 돌기
			go(start);
		}
	}

	// 테스트 케이스 빌딩 층 설정받기
	static boolean insertBuilding(StringTokenizer st, String br) {
		st = new StringTokenizer(br);

		// L,R,C넣기
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		// 셋 다 0이면 종료
		if (L == 0 && R == 0 && C == 0)
			return false;
		return true;
	}

	// 움직여보면서 가기
	static void go(int[] start) {
		Queue<int[]> q = new LinkedList<>();
		boolean[][][] check = new boolean[L + 1][R + 1][C + 1];
		q.add(new int[] { start[0], start[1], start[2], 0 });
		// 시작점 check
		check[start[0]][start[1]][start[2]] = true;

		while (!q.isEmpty()) {
			int[] now = q.poll();

			// 끝에 도착했으면 끝내기
			if (now[0] == end[0] && now[1] == end[1] && now[2] == end[2]) {
				System.out.printf("Escaped in %d minute(s).\n", now[3]);
				return;
			}

			// 6방향으로 움직이기
			for (int d = 0; d < 6; d++) {
				int l = dir[d][0] + now[0];
				int r = dir[d][1] + now[1];
				int c = dir[d][2] + now[2];
				int time = now[3] + 1;

				// 범위에서 벗어나나 확인
				if (l <= 0 || l > L || r <= 0 || r > R || c <= 0 || c > C)
					continue;
				// 갈 수 없는 곳인가 확인
				if (building[l][r][c] == '#')
					continue;
				// 이미 갔던 곳인가 확인
				if (check[l][r][c])
					continue;

				// visit 체크
				check[l][r][c] = true;
				// 다음에 여기에서 시작할 수 있도록 큐에 넣기
				q.add(new int[] { l, r, c, time });
			}
		}
		System.out.println("Trapped!");
	}
}
