package sw.d4;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SWEA1233 { // D4
	public static void main(String[] args) throws FileNotFoundException {
//		System.setIn(new FileInputStream("data/input1233.txt"));
		Scanner sc = new Scanner(System.in);
		StringTokenizer st;

		int T = 10;
		String op = "+-*/";
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(sc.nextLine());
			
			boolean ans = true;	//1 : 가능 , 0: 불가능
			for(int i = 0 ; i < N ; i++) {
				if(ans) {
					st = new StringTokenizer(sc.nextLine());
					st.nextToken(); //노드 번호
					if(!op.contains(st.nextToken())) {	//연산자 확인
						//연산자 아니야
						if(st.hasMoreTokens()) ans = false;
					}else {//연산자야
						if(!st.hasMoreTokens()) ans = false;
					}
				}else {
					sc.nextLine();
				}
			}
			
			System.out.println("#"+t+" "+ (ans?1:0));
		}
	}
}
