package beakjoon.silver;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 데스나이트 S1
public class Q16948 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// N*N (체스판)
		int N = sc.nextInt();

		// 체스판 초기화 (값 -1로 => 기본값이 -1임)
		int[][] arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(arr[i], -1);
		}

		// 이동 방향
		int[] dr = { -2, -2, 0, 0, 2, 2 };
		int[] dc = { -1, 1, -2, 2, -1, 1 };

		// 현재 위치
		int nr = sc.nextInt();
		int nc = sc.nextInt();

		// 목적지
		int gr = sc.nextInt();
		int gc = sc.nextInt();

		// BFS용 Queue
		Queue<int[]> q = new LinkedList<>();

		// 현재 위치 Queue에 삽입, arr 초기치 갱신
		q.add(new int[] { nr, nc });
		arr[nr][nc] = 0;

		// BFS 시작
		while (!q.isEmpty()) {
			int[] now = q.poll();

			// 6방향 확인
			for (int i = 0; i < 6; i++) {
				// 새로운 nr, nc 갱신
				nr = now[0] + dr[i];
				nc = now[1] + dc[i];

				// 맵 범위 확인 (맵 밖이면 다음 위치로 이동
				if (nr >= N || nr < 0 || nc >= N || nc < 0)
					continue;
				// 이미 지나간 곳이면 다음 위치로 이동
				if (arr[nr][nc] != -1)
					continue;

				// arr 갱신
				arr[nr][nc] = arr[now[0]][now[1]] + 1;
				// 큐에 다음 시작점으로 넣기
				q.add(new int[] { nr, nc });
			}
		}

		// 출력
		System.out.println(arr[gr][gc]);
	}
}
