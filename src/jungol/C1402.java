package jungol;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C1402 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		List<Integer> small = new ArrayList<>();
		
		for(int i = 1 ; i <= n ; i++) {
			if(n%i == 0) small.add(i);
		}
		
		if(small.size() < k) System.out.println(0);
		else System.out.println(small.get(k-1));
		
	}
}
