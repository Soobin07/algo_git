package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//35%에서 시간초과
public class Q11723 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;

		int M = Integer.parseInt(br.readLine());
		boolean[] list = new boolean[21];
		

		int sel = 0;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

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
				if(list[sel]) sb.append(1).append("\n");
				else sb.append(0).append("\n");
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
		System.out.print(sb.toString());
	}
}
