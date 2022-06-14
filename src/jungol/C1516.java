package jungol;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class C1516 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = null;
		
		String str = null;
		while((str = sc.nextLine())!= null && !str.equals("END")) {
			HashMap<String, Integer> map = new HashMap<>();
			st = new StringTokenizer(str);
			while(st.hasMoreTokens()) {
				String tmp = st.nextToken();
				if(map.containsKey(tmp)) {
					map.replace(tmp, map.get(tmp)+1);
				}else {
					map.put(tmp, 1);
				}
			}
			Map<String, Integer> sortedMap = new TreeMap<>(map);
			System.out.print(sortedMap.toString().replace("{", "").replace(" ", "").replace("}", "\n").replace("=", " : ").replace(",", "\n"));
		}
	}
}
