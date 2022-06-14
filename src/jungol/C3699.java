package jungol;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class C3699 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i = 0  ; i < T ; i++) {
			HashMap<String, Integer> map = new HashMap<>();
			int N = sc.nextInt();
			for(int j = 0 ; j < N ; j++) {
				sc.next();
				String str = sc.next();
				if(map.containsKey(str)) {
					map.replace(str, map.get(str)+1);
				}else {
					map.put(str, 1);
				}
			}
			int cnt = 1;
			for(Map.Entry<String, Integer> entry : map.entrySet()) {
				cnt *= (entry.getValue()+1);
			}
			cnt--;
			System.out.println(cnt);
		}
	}
}
