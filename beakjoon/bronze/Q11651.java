package beakjoon.bronze;

import java.util.Arrays;
import java.util.Scanner;
//백준에서는 두개의 클래스 허용 안됨
public class Q11651 {
	static class Dot implements Comparable<Dot>{
		int x = 0;
		int y = 0;
		public Dot(int x, int y) { 
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(Dot o) {
			if(y-o.y > 0) {
				return 1;
			}else if(y-o.y == 0) {
				if(x-o.x > 0) return 1;
			}
			return -1;
		}
		@Override
		public String toString() {
			return x + " " + y;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Dot[] dts = new Dot[n];
		int x, y;
		for(int i = 0 ; i < n ; i++) {
			x = sc.nextInt();
			y = sc.nextInt();
			dts[i] = new Dot(x, y);
		}
		Arrays.sort(dts);
		for(Dot d : dts) {
			System.out.println(d.toString());
		}
	}
}
