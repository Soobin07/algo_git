package jungol;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class C1535 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Set<String> set = new HashSet<>();
		StringBuffer sb = new StringBuffer();
		
		String str = null;
		while((str = sc.nextLine()) != null && !str.equals("END")) {
			String[] tmp = str.split(" ");
			for(int i = 0 ; i < tmp.length ; i++) {
				if(!set.contains(tmp[i])) {
					set.add(tmp[i]);
					sb.append(tmp[i]+" ");
				}
			}
			System.out.println(sb.toString());
		}
	}
}
