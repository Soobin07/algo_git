package sw.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA7964 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("data/sw/input7964.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1 ; t <= T ; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());
			
			//맵 받기
			int[] gates = new int[N+2];
			st = new StringTokenizer(br.readLine());
			gates[0] = gates[N+1] = 1;
			for(int i = 1 ; i < N+1 ; i++) {
				gates[i] = Integer.parseInt(st.nextToken());
			}
			
			//앞으로 D만큼 움직여서 1이 없으면 거기에 세운다
			int cnt = 0; //신규
			int dst = 0;
			for(int i = 1 ; i <= N ; i++) {
				if(gates[i] == 0) {
					dst++;
					if(dst == D) {
						cnt++;
						dst = 0;
					}
				}
				if(gates[i] == 1) dst = 0;
			}
			
			System.out.printf("#%d %d %n", t, cnt);
		}
	}
}
