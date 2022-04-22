package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//나는 2차원배열을 사용했지만, arr[N-1][1] = arr[N][0] 과 같았다
//따라서 arr[N] 을 1이 나오는 횟수로 채우고, N에 대해 출력하라 할 때, arr[N] 과 arr[N-1]을 출력할 수 있다.
public class Q1003 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int[][] arr = new int[41][2];
		arr[0][0] = 1;
		arr[1][1] = 1;
		for(int i = 2 ; i < 41 ; i++) {
			arr[i][0] = arr[i-1][0]+arr[i-2][0];
			arr[i][1] = arr[i-1][1]+arr[i-2][1];
		}
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 0 ; t < T ; t++) {
			int i = Integer.parseInt(br.readLine());
			sb.append(arr[i][0]).append(" ").append(arr[i][1]).append("\n");
		}
		System.out.print(sb.toString());
	}
}
