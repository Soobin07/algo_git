package jungol;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class C1459 {
	static int[] arr;
	static boolean[] visit;
	static List<Integer> list;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		arr = new int[N+1];	//idx+1
		visit = new boolean[N+1];
		list = new ArrayList<>();
		
		for(int i = 1 ; i <= N ; i++) {
			arr[i] = sc.nextInt();
		}//입력완료
		
		List<Integer> ans = new ArrayList<>();
		
		// 순환이면 정답에 포함
		for(int i = 1 ; i <= N ; i++) {
			list.clear();
			if(find(i,i) && !ans.contains(i)) {
				ans.addAll(list);
			}
		}
		Integer[] ansArr = ans.toArray(new Integer[0]);
		Arrays.sort(ansArr);
		
		System.out.println(ansArr.length);
		for(int i = 0 ; i < ansArr.length ; i++) {
			System.out.println(ansArr[i]);
		}
		
	}
	public static boolean find(int start, int idx) {
		if(start == arr[idx]) {
			list.add(idx);
			return true;
		}
		if(visit[idx]) return false;
		
		boolean flag = false;
		visit[idx] = true;
		list.add(idx);
		if(!visit[arr[idx]]) flag = find(start, arr[idx]);
		visit[idx] = false;
		return flag;
	}
}
