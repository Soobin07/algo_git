package beakjoon.platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백조의 호수
//최종
//1. 맵이 너무 방대할 경우, 다음 조건들을 알 수 있으면 미리 담아둬도 된다
//예를들어, 물 옆의 얼음이 녹는다. 백조들은 물로만 헤엄쳐 갈 수 있다. 
//=> 백조들이 얼음에 부딪치면, 다음번 백조들이 갈 수 있는 자리는 해당 얼음의 자리가 될 것이다 
//=> 다음번 백조 자리 확인 시, 부딪친 얼음의 자리를 백조의 자리로 두고 움직이자
//2. 반복되는 코드는 별도의 함수로 빼두자. (melt와 같이)
//3. 선택지가 2개 이상 있을 때는 의사코드(수도코드) 만들 때 어느쪽이 더 간단한가 확실히 확인해두자. (melt, ice 선택..)
public class Q3197 {

	static int R, C;
	static char[][] map;
	static int[] start, end;
	static Queue<int[]> melt_q, ice_q, swan_q, next_q;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// R,C 입력
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		// 초기화
		map = new char[R][C];
		melt_q = new LinkedList<>();
		ice_q = new LinkedList<>();
		swan_q = new LinkedList<>();
		next_q = new LinkedList<>();
		boolean[][] visit = new boolean[R][C];
		int day = 0;

		// 현재 상황 map 입력
		for (int i = 0; i < R; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = tmp.charAt(j);

				if (map[i][j] == 'X') {
					ice_q.add(new int[] { i, j });
					continue;
				}

				// 녹은 물이면 melt_q에 저장
				melt_q.add(new int[] { i, j });

				// 백조 위치 저장
				if (map[i][j] == 'L') {
					if (start == null) {
						start = new int[] { i, j };
						swan_q.add(start);
						visit[i][j] = true;
					} else {
						end = new int[] { i, j };
					}
				}
			}
		}

		while (!canMeet(visit)) {
//			melt();
			reverse_melt();
			day++;
		}

		System.out.println(day);
	}

	// 둘이 만날 수 있나?
	static boolean canMeet(boolean[][] visit) {
		next_q.clear();
		while (!swan_q.isEmpty()) {
			int[] now = swan_q.poll();
			// 상하좌우 보면서
			for (int k = 0; k < 4; k++) {
				// 이동 위치의 r, c
				int r = now[0] + dr[k];
				int c = now[1] + dc[k];

				// 맵 벗어나나?
				if (r >= R || r < 0 || c >= C || c < 0)
					continue;

				// 이미 갔던 곳인가?
				if (visit[r][c])
					continue;

				// visit 처리
				visit[r][c] = true;
				// 도착했으면 true 리턴
				if (end[0] == r && end[1] == c)
					return true;
				else if (map[r][c] == 'X') // 다음에 갈 수 있는 큐
					next_q.add(new int[] { r, c });
				else // 백조가 갈 수 있는 거리
					swan_q.add(new int[] { r, c });
			}
		}
		swan_q.addAll(next_q);
		return false;
	}

	// 녹는다
	static void melt() {
		next_q.clear();
		while (!melt_q.isEmpty()) {
			int[] now = melt_q.poll();
			// 상하좌우 보면서
			for (int k = 0; k < 4; k++) {
				// 이동 위치의 r, c
				int r = now[0] + dr[k];
				int c = now[1] + dc[k];

				// 맵 벗어나나?
				if (r >= R || r < 0 || c >= C || c < 0)
					continue;

				// 얼음이면 녹이기
				if (map[r][c] == 'X') {
					map[r][c] = '.';
					next_q.add(new int[] { r, c });
				}
			}
		}
		melt_q.addAll(next_q);
	}

	// 얼음을 포인트로 해서 만들면?
	static void reverse_melt() {
		next_q.clear();
		char[][] tmp_map = copy(map);
		while (!ice_q.isEmpty()) {
			int[] now = ice_q.poll();
			boolean flag = true; // 얼어있나?
			// 상하좌우 보면서
			for (int k = 0; k < 4; k++) {
				// 이동 위치의 r, c
				int r = now[0] + dr[k];
				int c = now[1] + dc[k];

				// 맵 벗어나나?
				if (r >= R || r < 0 || c >= C || c < 0)
					continue;

				// 얼음이냐?
				if (map[r][c] == 'X')
					continue;

				// 물이면 녹는다
				tmp_map[now[0]][now[1]] = '.';
				flag = false;
				break;
			}
			// 아직 얼어있으면 다음 q에 넣는다
			if (flag)
				next_q.add(now);
		}
		ice_q.addAll(next_q);
		map = tmp_map;
	}

	static char[][] copy(char[][] ori) {
		char[][] tmp = new char[ori.length][];
		for (int i = 0; i < tmp.length; i++) {
			tmp[i] = Arrays.copyOf(ori[i], ori[i].length);
		}
		return tmp;
	}
}
