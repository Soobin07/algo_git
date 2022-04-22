package sw.d2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1959 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("data/sw/input1959.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine()); // 테스트케이스
		for(int t = 1 ; t <= T ; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[] arrA = new int[N];
			int[] arrB = new int[M];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < N ; i++) {
				arrA[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < M ; i++) {
				arrB[i] = Integer.parseInt(st.nextToken());
			}
			
			if(N > M) {
				int tmp = N;
				N = M;
				M = tmp;
				int[] tmpArr = arrA;
				arrA = arrB;
				arrB = tmpArr;
			}
			
			int maxSum = 0;
			for(int i = 0 ; i <= M-N ; i++) {
				int sum = 0;
				for(int j = 0 ; j < N ; j++) {
					sum +=(arrA[j]*arrB[i+j]);
				}
				if(maxSum < sum) maxSum = sum;
			}
			
			sb.append("#").append(t).append(" ").append(maxSum).append("\n");
		}
		System.out.print(sb);
	}
}
