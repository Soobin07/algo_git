package jungol;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class C2809 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		List<Integer> list = new ArrayList<>();
		
		for(int i = 1 ; i*i <= N ; i++) {
			if(N%i == 0) {
				list.add(i);
				if(N/i != i)
					list.add(N/i);
			}
		}
		Integer[] tmp = list.toArray(new Integer[0]);
		Arrays.sort(tmp);
		for(int i = 0 ; i < list.size() ; i++) {
			System.out.print(tmp[i]+" ");
		}
	}
}
