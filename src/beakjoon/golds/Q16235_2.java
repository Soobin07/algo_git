package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q16235_2 {
	static class Tree implements Comparable<Tree> {
		int x, y, z;

		public Tree(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}

		@Override
		public int compareTo(Tree o) {
			return z - o.z;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 땅 넓이
		int M = Integer.parseInt(st.nextToken()); // 초기 나무 갯수
		int K = Integer.parseInt(st.nextToken()); // K년

		int[][] map = new int[N][N]; // 영양분 map
		// 영양분 map 초기화
		for (int i = 0; i < N; i++) {
			Arrays.fill(map[i], 5);
		}
		int[][] A = new int[N][N]; // 매년 겨울 더하는 양분 map
		// 겨울 양분 map 초기화
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 나무 정보 추가
		ArrayList<Tree> tmp = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			Tree tree = new Tree(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1,
					Integer.parseInt(st.nextToken()));
			tmp.add(tree);
		}
		Collections.sort(tmp, (t1, t2)-> t1.z - t2.z);
		
		Deque<Tree> trees = new LinkedList<>();
		for(int i = 0 ; i < M ; i++) {
			trees.add(tmp.get(i));
		}

		// 팔방향 기록하기
		int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };

		// 한 해 넘기기 (K년 반복)
		for (int k = 0; k < K; k++) {
			int[][] add = new int[N][N];
			Deque<Tree> nextYear = new LinkedList<>();

			// 나무 한번 싹 다 돌아보자
			while (!trees.isEmpty()) {
				Tree tree = trees.poll();
				// 봄(나이만큼 해당 위치에서 영양 빼주기)
				if (map[tree.x][tree.y] >= tree.z) {
					map[tree.x][tree.y] -= tree.z;
					// 한살 먹고 내년에도 보자
					tree.z += 1;
					nextYear.addLast(tree);

					// 가을 (살아있는 나무 나이가 5배수면 나무 8방향으로 번식)
					if (tree.z % 5 == 0) {
						for (int d = 0; d < 8; d++) {
							if (isInMap(N, tree.x + dr[d], tree.y + dc[d]))
								nextYear.addFirst(new Tree(tree.x + dr[d], tree.y + dc[d], 1));
						}
					}

				} else {
					// 여름(나이만큼 안남았으면 나무는 죽고 add에 z/2만큼 더해주기)
					add[tree.x][tree.y] += tree.z / 2;
				}
			}

			// 겨울 수동 양분 추가 + 여름에 죽은 나무 영양 더해주기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = map[i][j] + add[i][j] + A[i][j];
					add[i][j] = 0;
				}
			}
			trees = nextYear;
		}
		System.out.println(trees.size());
	}

	static boolean isInMap(int N, int x, int y) {
		if (x >= N || x < 0 || y >= N || y < 0)
			return false;
		return true;
	}
}
