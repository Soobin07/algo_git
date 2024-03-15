package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//카약
public class Q2890 {
	static class Ship implements Comparable<Ship> {
		int team, left, grade;

		@Override
		public int compareTo(Ship o) {
			return o.left - left;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		Ship[] teams = new Ship[9];

		int idx = 0;
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			int teamNo = teamNo(line);
			if (teamNo > 0) {
				teams[idx] = new Ship();
				teams[idx].team = teamNo;
				teams[idx].left = line.lastIndexOf("" + teamNo);
				idx++;
			}
		}

		Arrays.sort(teams);

		int no = 1;
		teams[0].grade = 1;
		for (int i = 1; i < 9; i++) {
			if (teams[i - 1].left != teams[i].left) {
				no++;
			}
			teams[i].grade = no;
		}

		Arrays.sort(teams, (o1, o2) -> {
			return o1.team - o2.team;
		});

		for (int i = 0; i < 9; i++) {
			System.out.println(teams[i].grade);
		}
	}

	static int teamNo(String str) {
		if (str.contains("1")) {
			return 1;
		} else if (str.contains("2")) {
			return 2;
		} else if (str.contains("3")) {
			return 3;
		} else if (str.contains("4")) {
			return 4;
		} else if (str.contains("5")) {
			return 5;
		} else if (str.contains("6")) {
			return 6;
		} else if (str.contains("7")) {
			return 7;
		} else if (str.contains("8")) {
			return 8;
		} else if (str.contains("9")) {
			return 9;
		}
		return 0;
	}
}
