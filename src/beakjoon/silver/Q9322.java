package beakjoon.silver;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

//for 문 두개로 찾아주는 부분을, 
// 첫번째 문자열을 받는 부분에서, 문자열 - 순서 를 사용하여 map으로 넣었으면
// 저 부분에 for을 쓰지 않아도 되었겠구나!
public class Q9322 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st;
		
		int T = Integer.parseInt(sc.nextLine());
		for(int t = 0 ; t < T ; t++) {
			int N = Integer.parseInt(sc.nextLine());
			String[] ori = new String[N];
			String[] clone = new String[N];
			int[] order = new int[N];
			
			st = new StringTokenizer(sc.nextLine());
			for(int i = 0 ; i < N ; i++) {
				ori[i] = st.nextToken();
			}
			
			st = new StringTokenizer(sc.nextLine());
			for(int i = 0 ; i < N ; i++) {
				clone[i] = st.nextToken();
				for(int j = 0 ; j < N ; j++) {
					if(ori[j].equals(clone[i])) {
						order[i] = j;
					}
				}
			}
			
			String[] normal = new String[N];
			st = new StringTokenizer(sc.nextLine());
			for(int i = 0 ; i < N ; i++) {
				normal[order[i]] = st.nextToken();
			}
			
			System.out.println(Arrays.toString(normal).replaceAll("[\\[\\,\\]]", ""));
		}
	}
}
