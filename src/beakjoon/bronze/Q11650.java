package beakjoon.bronze;

import java.util.Arrays;
import java.util.Scanner;

public class Q11650 {
	public static void main(String[] args) {
		class Dot implements Comparable<Dot>{
			int x;
			int y;
			public Dot(int x, int y) {
				this.x = x;
				this.y = y;
			}
			
			@Override
			public int compareTo(Dot o) {
				if(x-o.x > 0) return 1;
				if(x-o.x == 0 && y-o.y > 0) return 1;
				return -1;
			}

			@Override
			public String toString() {
				return x +" " + y;
			}
		}
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Dot[] dots = new Dot[n];
		for(int i = 0 ; i < n ; i ++) {
			dots[i] = new Dot(sc.nextInt(), sc.nextInt());
		}
		Arrays.sort(dots);
		StringBuffer sb = new StringBuffer();
		for(Dot dot : dots){
			sb.append(dot.toString());
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
