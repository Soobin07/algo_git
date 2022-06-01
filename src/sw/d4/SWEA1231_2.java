package sw.d4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SWEA1231_2 { // d4

	static StringBuffer sb;
	static char[] arr;
	static int N;

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("data/input1231.txt"));
		Scanner sc = new Scanner(System.in);
		sb = new StringBuffer();

		int T = 10;
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			N = sc.nextInt();
			arr = new char[N + 1];

			// 자료받기
			for (int i = 1; i <= N; i++) {
				arr[sc.nextInt()] = sc.next().charAt(0);
				sc.nextLine();
			}

			func(1);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	static void func(int index) {
		if (index * 2 <= N)
			func(index * 2);
		sb.append(arr[index]);
		if (index * 2 + 1 <= N)
			func(index * 2 + 1);
	}
}
