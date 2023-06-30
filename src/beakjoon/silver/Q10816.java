package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Q10816 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st = null;
		
		//가진 카드 배열
		int N = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer> map = new HashMap<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if(map.containsKey(tmp)) {
				map.replace(tmp, map.get(tmp)+1);
			}else {
				map.put(tmp, 1);
			}
		}
		
		//찾을 숫자들
		int M = Integer.parseInt(br.readLine());
		//비교하며 찾기
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < M ; i++) {
			int find = Integer.parseInt(st.nextToken());
			if(map.containsKey(find)) {
				sb.append(map.get(find)+" ");
			}else {
				sb.append("0 ");
			}
			
		}
		
		System.out.println(sb.toString());
	}
}
