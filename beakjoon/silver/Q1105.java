package beakjoon.silver;

import java.util.Scanner;

public class Q1105 {
	static String input1="1 10";	//0
	static String input2="88 88";	//2
	static String input3="800 899";	//1
	static String input4="8808 8880";//2
	static String input5="128 138"; //0
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(input5);
		
		String L = Integer.toString(sc.nextInt());
		String R = Integer.toString(sc.nextInt());
		
		int cnt = 0;
		if(R.length() == L.length()) {	//자리수 다르면 신경 안쓰고 0 해도 될듯
			for(int i = 0 ; i < L.length() ; i++) {
				int ch_l = L.charAt(i)-'0';
				int ch_r = R.charAt(i)-'0';
				if(ch_l != ch_r) break;
				if(ch_l == ch_r && ch_r == 8) cnt++;
			}
		}
		System.out.println(cnt);
	}
}
