package sw.d2;

import java.io.FileInputStream;
import java.util.Scanner;

public class SWEA1940 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("data/sw/input1940.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		int T = sc.nextInt();
		for(int t = 1 ; t <= T ; t++) {
			int N = sc.nextInt();
			int speed = 0;
			int m = 0;
			for(int i = 0 ; i < N ; i++) {
				int sel = sc.nextInt();
				if(sel == 0) m += speed;
				else if(sel == 1) {
					speed += sc.nextInt();
					m += speed;
				}else {
					speed -= sc.nextInt();
					if(speed < 0) speed = 0;
					m += speed;
				}
			}
			sb.append("#").append(t).append(" ").append(m).append("\n");
		}
		System.out.print(sb);
	}
}
