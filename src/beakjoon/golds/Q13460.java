package beakjoon.golds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q13460 {
	static class Node {
		int move_cnt;
		int blueX, blueY;
		int redX, redY;

		public Node(int move_cnt, int blueX, int blueY, int redX, int redY) {
			this.move_cnt = move_cnt;
			this.blueX = blueX;
			this.blueY = blueY;
			this.redX = redX;
			this.redY = redY;
		}

		public Node() {
		}

		public Node copy() {
			return new Node(move_cnt, blueX, blueY, redX, redY);
		}

		@Override
		public String toString() {
			return "Node [move_cnt=" + move_cnt + ", blueX=" + blueX + ", blueY=" + blueY + ", redX=" + redX + ", redY="
					+ redY + "]";
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Queue<Node> q = new LinkedList<>();
		int[] hole = new int[2];
		Node first = new Node();

		char[][] map = new char[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'R') {
					first.redX = i;
					first.redY = j;
					map[i][j] = '.';
				} else if (map[i][j] == 'B') {
					first.blueX = i;
					first.blueY = j;
					map[i][j] = '.';
				} else if (map[i][j] == 'O') {
					hole[0] = i;
					hole[1] = j;
				}
			}
		}

		q.add(first);
		int[] dr = { 0, 0, -1, 1 };
		int[] dc = { -1, 1, 0, 0 };
		int ans = -1;
		outline: while (!q.isEmpty()) {
			// 꺼내기
			Node now = q.poll();
			// 만약 move_cnt가 10이상이면 그냥 종료 (한번 더 움직이면 10회 초과니까)
			if (now.move_cnt >= 10) {
				break outline;
			}

			// 상하좌우로 판 기울이기
			inline: for (int i = 0; i < 4; i++) {
				Node new_node = now.copy();
				new_node.move_cnt += 1;

				int move_r = 0;
				// R움직이기
				while (true) {
					move_r++;
					new_node.redX += dr[i];
					new_node.redY += dc[i];
					// # 만나면 한칸 전으로 이동하고 그만 움직이기
					// O 만나면 그만 움직이기
					if (map[new_node.redX][new_node.redY] == '#') {
						new_node.redX -= dr[i];
						new_node.redY -= dc[i];
						move_r--;
						break;
					} else if (map[new_node.redX][new_node.redY] == 'O') {
						break;
					}
				}
				int move_b = 0;
				// B움직이기
				while (true) {
					move_b++;
					new_node.blueX += dr[i];
					new_node.blueY += dc[i];
					// # 만나면 한칸 전으로 이동하고 그만 움직이기
					// O 만나면 그만 움직이기
					if (map[new_node.blueX][new_node.blueY] == '#') {
						new_node.blueX -= dr[i];
						new_node.blueY -= dc[i];
						move_b--;
						break;
					} else if (map[new_node.blueX][new_node.blueY] == 'O') {
						break;
					}
				}
				// 만약 둘 다 같은 위치라면
				if (new_node.redX == new_node.blueX && new_node.redY == new_node.blueY) {
					/*
					 * //둘 다 O면 누가 더 먼저 도착? => 둘 다 O면 그냥 실패임. if(map[new_node.redX][new_node.redY]
					 * == 'O') { //r이 먼저 도착함. 답이다 (이거 아님) if(move_r < move_b) { ans =
					 * new_node.move_cnt; break outline; } //b가 먼저 도착하거나 동시에 도착함 => 답 아님, 진행 안됨. 버리기
					 */
					if (map[new_node.redX][new_node.redY] == 'O') {
						// 실패
						continue inline;
					} else {
						// 둘 다 #면 누가 먼저 도착? => 절대 동시일 수 없음
						if (move_r < move_b) {
							// r이 먼저 도착 => b를 한칸 뒤로 보내자
							new_node.blueX -= dr[i];
							new_node.blueY -= dc[i];
						} else {
							new_node.redX -= dr[i];
							new_node.redY -= dc[i];
						}
					}
				} else {
					// 다른 위치라면 O 확인
					if (map[new_node.redX][new_node.redY] == 'O') {
						ans = new_node.move_cnt;
						break outline;
					} else if (map[new_node.blueX][new_node.blueY] == 'O') {
						// 실패
						continue inline;
					}
					/*
					 * // 둘 다 움직이지 못했으면 그냥 저장하지 말자 if (now.redX == new_node.redX && now.redY ==
					 * new_node.redY && now.blueX == new_node.blueX && now.blueY == new_node.blueY)
					 * { continue inline; }
					 */
				}
				// O 아니면 큐에 저장
				q.add(new_node);
			}
		}
		System.out.println(ans);
	}
}
