package beakjoon.bronze;

import java.util.Scanner;

public class Q4153 {
	public static void main(String[] args) {
		//포인트는 순서가 바뀌어도 s에 가장 큰 수를 넣는 것
		
		Scanner sc = new Scanner(System.in);
		int w, h, s;
		
		do {
			w = sc.nextInt();
			h = sc.nextInt();
			s = sc.nextInt();
			
			if(s < w) {
				int tmp = s;
				s = w;
				w = tmp;
			}
			if(s < h) {
				int tmp = s;
				s = h;
				h = tmp;
			}
			
			
			if(!(w==0&&h==0&&s==0)) {
				if((w*w+h*h-s*s) == 0) System.out.println("right");
				else System.out.println("wrong");
			}
		}while(!(w==0&&h==0&&s==0));
	}
}
