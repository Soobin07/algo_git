package beakjoon.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

//HashMap 사용해보자 => 가능한데 1916ms
public class Q2776_2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int TC = Integer.parseInt(st.nextToken());
		for(int tc = 0 ; tc < TC ; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			HashSet<Integer> map = new HashSet<>();
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < N ; i++) {
				map.add(Integer.parseInt(st.nextToken()));
			}
			
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < M ; i++) {
				if(map.contains(Integer.parseInt(st.nextToken()))) {
					bw.append("1\n");
				}else {
					bw.append("0\n");
				}
			}
			
			bw.flush();
		}
		bw.close();
		br.close();
	}
}
