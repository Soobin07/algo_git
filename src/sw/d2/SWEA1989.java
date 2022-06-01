package sw.d2;

import java.util.Scanner;

public class SWEA1989 {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("data/sw/input1989.txt"));
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();

		int T = Integer.parseInt(sc.nextLine());
		for(int t = 1 ; t <= T ; t++) {
//			String str = sc.nextLine();
//			int result = 1;
//			for(int i = 0 ; i < str.length()/2 ; i++) {
//				if(str.charAt(i) != str.charAt(str.length()-1 -i)) {
//					result = 0; break;
//				}
//			}
			sb.append("#").append(t).append(" ").append(isPalindrome(sc.nextLine())).append("\n");
//			System.out.printf("#%d %d%n", t, isPalindrome(sc.nextLine()));
		}
		System.out.print(sb);
	}
	static int isPalindrome(String str) {
		int result = 1; //초기값
		int len = str.length();
		for(int i = 0 ; i < len/2 ; i++) {
			//charAt보다 toCharArray가 더 느릴 수 있다 (Array를 만들어 return해야 하니까)
			if(str.charAt(i) != str.charAt(len-1 -i)) {	
				result = 0; break;
			}
		}
		return result;
	}
}
