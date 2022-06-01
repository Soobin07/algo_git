package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Q11004 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		List<Integer> arr = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			arr.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(arr);
		
		System.out.println(arr.get(K-1));
	}
	
	//Collections.sort로 Integer을 sort하는 것이 Arrays.sort로 int를 sort하는 것 보다 빠르대!
}
