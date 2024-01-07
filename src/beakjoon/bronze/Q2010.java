package beakjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//플러그
public class Q2010 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		// 최대로 전원에 연결될 수 있는 컴퓨터의 수
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(br.readLine());
			cnt += tmp - 1;
			if(i == N-1)
				cnt++;
		}
		
		System.out.println(cnt);
	}
}
