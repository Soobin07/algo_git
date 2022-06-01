package sw.d2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class SWEA2005 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("data/sw/input2005.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1 ; t <= T ; t++) {
			sb.append("#").append(t).append("\n");
			int N = Integer.parseInt(br.readLine());
			int[] arr_ori = new int[N];
			int[] arr_new = new int[N];
			
			for(int i = 0 ; i < N ; i++) { //1개~N개 될 때 까지 횟수
				arr_new = new int[N];
				arr_new[0] = 1;
				for(int j = 1 ; j < i ; j++) {
					arr_new[j] = arr_ori[j]+arr_ori[j-1];
				}
				arr_new[i] = 1;
				arr_ori = arr_new;
				
				for(int j = 0 ; j <= i ; j++) {
					sb.append(arr_ori[j]).append(" ");
				}
				sb.append("\n");
			}
		}
		System.out.print(sb);
	}
}
