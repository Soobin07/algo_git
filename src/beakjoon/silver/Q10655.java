package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10655 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N+1][2];
		
		for(int i = 1 ; i <= N ; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		//바로 다음 지점까지의 거리
		int[] dist = new int[N+1];
		for(int i = 1 ; i < N ; i++) {
			dist[i] = Math.abs(arr[i+1][0] - arr[i][0]) + Math.abs(arr[i+1][1] - arr[i][1]);
		}
		
		//바로 다음 지점 하나를 뒤어넘는 거리
		int[] out = new int[N+1];
		for(int i = 1 ; i < N-1 ; i++) {
			out[i] = Math.abs(arr[i+2][0] - arr[i][0]) + Math.abs(arr[i+2][1] - arr[i][1]);
		}
		
		int idx = -1;
		int max_gap = 0;
		int tmp = 0;
		for(int i = 1 ; i < N-1 ; i++) {
			tmp = dist[i]+dist[i+1] - out[i];
			if(tmp > max_gap) {
				idx = i;
				max_gap = tmp;
			}
		}
		
		int ans = 0;
		for(int i = 1 ; i <= N ; i++) {
			if(i == idx || i == idx+1)
				continue;
			ans += dist[i];
		}
		ans += out[idx];
		
		System.out.println(ans);
	}
}
