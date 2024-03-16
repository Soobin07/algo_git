package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q2891 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 팀의 수
		int S = Integer.parseInt(st.nextToken()); // 손상된 팀의 수
		int R = Integer.parseInt(st.nextToken()); // 하나 더 가져온 팀의 수

		// 카약 가진 팀
		boolean[] haveK = new boolean[N + 2];
		Arrays.fill(haveK, true);

		// 손상된 것 등록
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < S; i++) {
			haveK[Integer.parseInt(st.nextToken())] = false;
		}

		// 하나 더 가져온 팀 리스트 받기
		ArrayList<Integer> more = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++)
			more.add(Integer.parseInt(st.nextToken()));

		// 정렬한다
		Collections.sort(more);

		// 본인 팀의 것이 망가진 경우 먼저 고친다
		for (int i = more.size() - 1; i >= 0; i--) {
			if(!haveK[more.get(i)]) {
				haveK[more.get(i)] = true;
				more.remove(i);
			}
		}

		// 하나 더 가져온 팀의 행동
		for (int i = 0; i < more.size(); i++) {
			// 본인들 없으면 쓴다
			if (!haveK[more.get(i) - 1]) {
				haveK[more.get(i) - 1] = true;
			} else if (!haveK[more.get(i) + 1]) {
				haveK[more.get(i) + 1] = true;
			}
		}

		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			if (!haveK[i])
				cnt++;
		}

		System.out.println(cnt);
	}
}
