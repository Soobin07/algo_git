package beakjoon.bronze;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Q1181 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//1. 길이 짧
		//2. 길이 같으면 사전순
		//3. 같은 단어 => 한번만
		
		int n = Integer.parseInt(sc.nextLine());
		
		Set<String> set = new HashSet<>();
		for(int i = 0 ; i < n ; i++) {
			set.add(sc.nextLine());
			System.out.println(i);
		}
		
		String[] ori = set.toArray(new String[0]);
		System.out.println(Arrays.toString(ori));
		Arrays.sort(ori, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(o1.length() == o2.length()) {
					for(int i = 0 ; i < o1.length() ; i++) {
						int tmp = o1.charAt(i)-o2.charAt(i);
						if(tmp != 0) return o1.charAt(i)-o2.charAt(i);
					}
				}
				return o1.length() - o2.length();
			}
		});
		
		for(String str : ori) {
			if(!str.equals("")) {
				System.out.println(str);
			}
		}
	}
}

//collections의 sort를 하였을 때, sort 실행 순서에 따라 영향을 받는다.
//Collections.sort(arr, (a,b)-> a.comparebleTo(b));
//Collections.sort(arr, (a,b)-> a.length() - b.langth()); //이렇게는 가능, 반대는 불가능
