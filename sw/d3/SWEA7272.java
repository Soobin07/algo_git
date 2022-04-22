package sw.d3;

import java.io.FileInputStream;
import java.util.Scanner;

public class SWEA7272 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("data/sw/input7272.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t = 1 ; t <= T ; t++) {
			String ans = "DIFF";
			String[] lines = new String[2];
			//일단 받고, 길이 다르면 다르다고 끝내는 분도 계시네
			//그 후에 한글자씩 비교하면서 저 안에 글자가 0,1,B 어느것인지 확인하고
			//다르면 거기서 종료 할 수도 있구나.
			for(int i = 0 ; i < 2 ; i++) {
				lines[i] = sc.next();
				lines[i] = lines[i].replaceAll("[CEFGHIJKLMNSTUVWXYZ]", "0");
				lines[i] = lines[i].replaceAll("[ADOPQR]", "1");
			}
			if(lines[0].equals(lines[1])) ans = "SAME";
			System.out.printf("#%d %s%n", t, ans);
		}
	}
}
