package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Q15663 {
	static int[] sel;
	static int[] arr;
	static boolean[] visit;
	static int M;
	static Set<String> ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		ans = new HashSet<String>();
		
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sel = new int[M];
		arr = new int[N];
		visit = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		select(0);
		
		/*
		String[] ans_str = ans.toArray(new String[0]);
		Arrays.sort(ans_str);
		System.out.print(Arrays.toString(ans_str).replaceAll("[\\[\\]]", "").replace(", ", "\n"));
		*/
	}
	
	static void select(int idx) {
		if(idx == M) {
			String tmp = Arrays.toString(sel).replaceAll("[\\[,\\]]", "");
			if(!ans.contains(tmp)) {
				System.out.println(tmp);
				ans.add(tmp);
			}
			return;
		}
		for(int i = 0 ; i < arr.length ; i++) {
			if(!visit[i]) {
				visit[i] = true;
				sel[idx] = arr[i];
				select(idx+1);
				visit[i] = false;
			}
		}
	}
}
