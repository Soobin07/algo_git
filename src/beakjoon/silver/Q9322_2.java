package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

//for 문 두개로 찾아주는 부분을, 
// 첫번째 문자열을 받는 부분에서, 문자열 - 순서 를 사용하여 map으로 넣었으면
// 저 부분에 for을 쓰지 않아도 되었겠구나!
public class Q9322_2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());

			String[] ori = new String[N];
			Map<String, Integer> map = new HashMap<>();
			int[] order = new int[N];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				ori[i] = st.nextToken();
				map.put(ori[i], i);
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				order[i] = map.get(st.nextToken());
			}

			String[] normal = new String[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				normal[order[i]] = st.nextToken();
			}

			for(int i = 0 ; i < N ; i++) {
				sb.append(normal[i]).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
