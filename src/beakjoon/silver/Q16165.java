package beakjoon.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

//걸그룹 마스터 준석이
public class Q16165 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		// 값 받기
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 걸그룹 수
		int M = Integer.parseInt(st.nextToken()); // 맞춰야 할 문제의 수

		HashMap<String, String> map = new HashMap<>();
		HashMap<String, String[]> teams = new HashMap<>();
		for (int i = 0; i < N; i++) {
			String team = br.readLine(); // 팀명
			int cnt = Integer.parseInt(br.readLine()); // 인원
			String[] arr = new String[cnt];
			for (int j = 0; j < cnt; j++) {
				String name = br.readLine();
				map.put(name, team);
				arr[j] = name;
			}
			Arrays.sort(arr);
			teams.put(team, arr);
		}

		for (int i = 0; i < M; i++) {
			String name = br.readLine();
			int question = Integer.parseInt(br.readLine());
			if (question == 0) {
				bw.append(Arrays.toString(teams.get(name)).replaceAll("[\\[ \\]]", "").replaceAll("[,]", "\n"));
				bw.append("\n");
			} else {
				bw.append(map.get(name) + "\n");
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
