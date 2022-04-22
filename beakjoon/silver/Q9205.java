package beakjoon.silver;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Q9205 {
	static String input1 = "2\r\n" + "2\r\n" + "0 0\r\n" + "1000 0\r\n" + "1000 1000\r\n" + "2000 1000\r\n" + "2\r\n"
			+ "0 0\r\n" + "1000 0\r\n" + "2000 1000\r\n" + "2000 2000";
	static String input2 = "1\r\n" + "4\r\n" + "2000 0\r\n" + "1000 0\r\n" + "0 0\r\n" + "0 1000\r\n" + "0 2000\r\n"
			+ "1000 2000";
	static String input3 = "1\r\n" + "1\r\n" + "0 0\r\n" + "9999 9999\r\n" + "0 1";
	static String input4 = "1\r\n" + "\r\n" + "0\r\n" + "\r\n" + "0 0\r\n" + "\r\n" + "1000 0";
	static String input5 = "1\r\n" + "2\r\n" + "0 0\r\n" + "0 1001\r\n" + "1 1\r\n" + "1000 1001";

	public static void main(String[] args) {
		Scanner sc = new Scanner(input4);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			String answer = "happy";
			int N = sc.nextInt(); // 편의점 갯수

			// 시작점(상근이네 집)
			int x = sc.nextInt();
			int y = sc.nextInt();

			// 편의점 N개 저장
			int[][] arrCom = new int[N][2];
			for (int n = 0; n < N; n++) {
				arrCom[n][0] = sc.nextInt();
				arrCom[n][1] = sc.nextInt();
			}

			// 도착지점 좌표
			int finX = sc.nextInt();
			int finY = sc.nextInt();

			Queue<int[]> allDir = new LinkedList<>();
			Set<int[]> visit = new HashSet<>();

			int[] start = { x, y };
			allDir.add(start);
			visit.add(start);

			while (true) {
				// 갈 수 있는 곳이 없을때
				if (allDir.isEmpty()) {
					answer = "sad";
					break;
				}

				int[] corr = allDir.poll();

				// 현재 지점과 도착지점의 차가 1000 이내면 break
				if (Math.abs(finX - corr[0]) + Math.abs(finY - corr[1]) <= 1000)
					break;

				// 현재 지점에서 갈 수 있는 좌표 찾아 넣기
				for (int i = 0; i < arrCom.length; i++) {
					if (Math.abs(arrCom[i][0] - corr[0]) + Math.abs(arrCom[i][1] - corr[1]) <= 1000
							&& !visit.contains(arrCom[i])) {
						allDir.add(arrCom[i]);
						visit.add(arrCom[i]);
					}
				}
			}
			System.out.println(answer);
		}
	}
}
