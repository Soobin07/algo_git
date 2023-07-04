package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2485 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long ans = 0;
		int N = Integer.parseInt(br.readLine());
		long[] arr = new long[N];
		
		//배열에 넣기
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		//배열 정리
		Arrays.sort(arr);
		
		//가장 짧은 거리 찾기
		long shortist = arr[N-1] - arr[0];
		for(int i = 1 ; i < N ; i++) {
			
			if((arr[i] - arr[i-1]) >= shortist && (arr[i] - arr[i-1])%shortist == 0)
				continue;
			
			long a = shortist;
			long b = arr[i] - arr[i-1];

			long tmp = a;
			if(a < b) {
				a = b;
				b = tmp;
			}
			
			//거리 차가 짧은 거리로 나누어 떨어지나?
			while(b != 0) {
				tmp = a % b;
				a = b;
				b = tmp;
			}
			
			shortist = a;
		}
		
		//최소공배수 찾아서 사이 메꿔주기
		ans = ((arr[N-1]-arr[0])/shortist) - (N-1);
		System.out.println(ans);
	}
}
