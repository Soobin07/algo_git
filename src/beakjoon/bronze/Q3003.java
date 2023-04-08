package beakjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q3003 {
	public static void main(String[] args) throws Exception{
		//k 1, q 1, l 2, v 2, n 2, p 8
		// kqlvnp 순서
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		StringBuffer sb = new StringBuffer();
		
		st = new StringTokenizer(br.readLine());
		int[] arr = {1, 1, 2, 2, 2, 8};
		for(int i = 0 ; i < 6 ; i++) {
			sb.append(arr[i] - Integer.parseInt(st.nextToken()) + " ");
		}
		
		System.out.println(sb.toString());
	}
}
