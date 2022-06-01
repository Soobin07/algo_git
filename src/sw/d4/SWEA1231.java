package sw.d4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SWEA1231 { // d4
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("data/input1231.txt"));
		Scanner sc = new Scanner(System.in);

		int T = 10;
		for (int t = 1; t <= T; t++) {
			StringBuffer sb = new StringBuffer();
			sb.append("#").append(t).append(" ");
			int N = sc.nextInt();
			boolean[] printed = new boolean[N + 1];
			char[] chars = new char[N + 1];

			// 자료받기
			for (int i = 1; i <= N; i++) {
				chars[sc.nextInt()] = sc.next().charAt(0);
				sc.nextLine();
			}

			int idx = 1;
			while (true) {
				if (idx * 2 <= N && !printed[idx * 2]) {
					idx *= 2;
				} else {
					if(!printed[idx]) {
						sb.append(chars[idx]);
						printed[idx] = true;
						int count = 0;
						for(int i = 1 ; i <= N ; i++) {
							if(printed[i]) count++;
						}
						if(count == N) break;
					}
					
					if (idx * 2 + 1 <= N && !printed[idx * 2 + 1]) {
						idx = idx * 2 + 1;
					} else {
						idx /= 2;
					}
				}
			}
			System.out.println(sb.toString());
		}
	}
}
