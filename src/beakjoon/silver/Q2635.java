package beakjoon.silver;

import java.util.ArrayList;
import java.util.Scanner;

public class Q2635 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0 ; i <= N/2 ; i++) {
			//반보다 큰것
			if(list.size() < getNum(N, N+i)) {
				list = (ArrayList<Integer>) tmp_Array.clone();
			}
			//반보다 작은것
			if(list.size() < getNum(N, N-i)) {
				list = (ArrayList<Integer>) tmp_Array.clone();
			}
		}
		
		System.out.println(list.size());
		for(int i = 0 ; i < list.size() ; i++) {
			System.out.print(list.get(i)+" ");
		}
	}
	
	static ArrayList<Integer> tmp_Array = new ArrayList<>();
	public static int getNum(int before, int after) {
		tmp_Array.clear();
		tmp_Array.add(before);
		tmp_Array.add(after);
		
		int cnt = 2;
		while(before - after >= 0) {
			int tmp = before-after;
			if(tmp < 0) break;
			tmp_Array.add(tmp);
			before = after;
			after = tmp;
			cnt++;
		}
		return cnt;
	}
}
