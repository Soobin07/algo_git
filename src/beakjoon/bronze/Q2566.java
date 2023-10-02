package beakjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2566 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int max = -1;
		int r = 0;
		int c = 0;
		
		for(int i = 1 ; i < 10 ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1 ; j < 10 ; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if(max < tmp) {
					max = tmp;
					r = i;
					c = j;
				}
			}
		}
		
		System.out.println(max);
		System.out.println(r+" "+c);
	}
}
