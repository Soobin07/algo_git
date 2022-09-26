package beakjoon.silver;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Q1269 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Set<Integer> set = new HashSet<>();
		
		int aNum = sc.nextInt();
		int bNum = sc.nextInt();
		
		int comb = 0;
		for(int i = 0 ; i < aNum ; i++) {
			set.add(sc.nextInt());
		}
		
		for(int i = 0 ; i < bNum ; i++) {
			int tmp = sc.nextInt();
			if(set.contains(tmp)) {
				comb++;
				continue;
			}
			set.add(tmp);
		}
		
		System.out.println(aNum+bNum-2*comb);
	}
}
