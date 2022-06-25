package jungol;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class C1490 {
	
	static Set<String> visit = new HashSet<>();
	static List<int[]> arr = new ArrayList<>();
	static int N, K;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		
		int[] exc = new int[K];
		for(int i = 0 ; i < K ; i++) {
			exc[i] = sc.nextInt();
		}
		
		comb(0, new int[K], new boolean[N+1]);
		
		boolean flag = false;
		for(int i = 0 ; i < arr.size() ; i++) {
			int[] tmp = arr.get(i);
			if(flag) {
				System.out.println(Arrays.toString(arr.get(i)).replaceAll("\\[|\\]|,", ""));
				break;
			}else if(Arrays.toString(arr.get(i)).equals(Arrays.toString(exc)) && i < arr.size()-1){
				flag = true;
			}
		}
		if(!flag) {
			System.out.println("NONE");
		}
	}
	public static void comb(int sidx, int[] sel, boolean[] visited) {
		if(sidx == sel.length) {
			int[] tmp = Arrays.copyOf(sel, K);
			Arrays.sort(tmp);
			if(!visit.contains(Arrays.toString(tmp))) {
				visit.add(Arrays.toString(tmp));
				arr.add(tmp);
			}
			return;
		}
		for(int i = 1 ; i <= N ; i++) {
			if(!visited[i]) {
				visited[i] =  true;
				sel[sidx] = i;
				comb(sidx+1, sel, visited);
				visited[i] = false;
			}
		}
	}
}
