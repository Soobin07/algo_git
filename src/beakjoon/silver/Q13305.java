package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q13305 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		long ans = 0;
		//도시 갯수
		int N = Integer.parseInt(br.readLine());
		//도시 간 거리
		long[] len = new long[N-1];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N-1 ; i++) {
			len[i] = Long.parseLong(st.nextToken());
		}
		//도시 별 가격
		long[] cost = new long[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			cost[i] = Long.parseLong(st.nextToken());
		}
		//앞에서부터 쭉 가다가 cost를 비교한다. 더 작은 수면 가지고 있는다
		long min = cost[0];
		for(int i = 0 ; i < N-1 ; i++) {
			if(min > cost[i]) {
				min = cost[i];
			}
			ans += min * len[i];
		}
		
		System.out.println(ans);
	}
}
