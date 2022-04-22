package beakjoon.silver;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

//35%에서 시간초과
public class Q11723_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st;

		int M = Integer.parseInt(sc.nextLine());
		boolean[] list = new boolean[21];

		int sel = 0;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(sc.nextLine());

			switch (st.nextToken()) {
			case "add":
				sel = Integer.parseInt(st.nextToken());
				list[sel] = true;
				break;
			case "remove":
				sel = Integer.parseInt(st.nextToken());
				list[sel] = false;
				break;
			case "check":
				sel = Integer.parseInt(st.nextToken());
				if(list[sel]) System.out.println(1);
				else System.out.println(0);
				break;
			case "toggle":
				sel = Integer.parseInt(st.nextToken());
				list[sel] = !list[sel];
				break;
			case "all":
				Arrays.fill(list, true);
				break;
			case "empty":
				Arrays.fill(list, false);
				break;
			}
		}
	}
}
