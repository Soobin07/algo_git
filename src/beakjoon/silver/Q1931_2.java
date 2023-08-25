package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

//end 기준으로 다시
public class Q1931_2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		//조건 받기
		int N = Integer.parseInt(br.readLine());
		int[][] meetings = new int[N][2];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			meetings[i] = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
		}
		
		//end 순서대로 정리
		Arrays.sort(meetings, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				//end 같으면 start 빠른게 앞
				if(o1[1] == o2[1])
					return o1[0] - o2[0];
				return o1[1] - o2[1];
			}
		});
		
		//앞에서부터 끝나는 시간 찾기
		int end = 0;
		int cnt = 0;
		for(int i = 0 ; i < N ; i++) {
			if(end <= meetings[i][0]) {
				cnt++;
				end = meetings[i][1];
			}
		}
		
		System.out.println(cnt);
	}
}
