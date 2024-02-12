package beakjoon.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//랭킹전 대기열
public class Q20006 {
	static class Player implements Comparable<Player> {
		int lv;
		String name;

		public Player() {
		}

		public Player(int lv, String name) {
			this.lv = lv;
			this.name = name;
		}

		@Override
		public int compareTo(Player o) {
			return name.compareTo(o.name);
		}

		@Override
		public String toString() {
			return lv + " " + name + "\n";
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int p = Integer.parseInt(st.nextToken()); // 플레이어 수
		int m = Integer.parseInt(st.nextToken()); // 한 방에 들어갈 수 있는 플레이어 수

		// 게임의 리스트
		ArrayList<ArrayList<Player>> list = new ArrayList<>();

		// 플레이어 한명씩 입장
		for (int i = 0; i < p; i++) {
			st = new StringTokenizer(br.readLine());
			Player pl = new Player(Integer.parseInt(st.nextToken()), st.nextToken());
			boolean flag = true; // 아직 게임 구하고 있나?
			// 방 순회
			for (int j = 0; j < list.size(); j++) {
				ArrayList<Player> game = list.get(j);
				if (flag) {
					// 넣을 수 있음 (아직 방 다 안참, 플레이어 레벨 기준 안에 들어감)
					if (game.size() < m && game.get(0).lv + 10 >= pl.lv && game.get(0).lv - 10 <= pl.lv) {
						game.add(pl); // 넣음
						flag = false; // 이미 들어갔음
						break;
					}
				}
			}

			// 아직 못들어감
			if (flag) {
				// 새로 만들어 넣음
				ArrayList<Player> game = new ArrayList<>();
				game.add(pl);
				list.add(game);
			}
		}

		// 게임 리스트 돌면서 확인하기
		for (int i = 0; i < list.size(); i++) {
			ArrayList<Player> t_game = list.get(i);
			Collections.sort(t_game);
			if (t_game.size() == m) {
				bw.append("Started!\n");
			} else {
				bw.append("Waiting!\n");
			}
			for (int j = 0; j < t_game.size(); j++) {
				bw.append(t_game.get(j).toString());
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
