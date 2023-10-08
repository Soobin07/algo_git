package beakjoon.golds;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q7682 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] dis = { "012", "345", "678", "036", "147", "258", "048", "246" };
		String str = br.readLine();
		while (!str.equals("end")) {
			String ans = "valid\n";
			// 갯수 세기
			int cntX = 0;
			int cntO = 0;
			for (int i = 0; i < 9; i++) {
				char ch = str.charAt(i);
				if (ch == 'O') {
					cntO++;
				} else if (ch == 'X') {
					cntX++;
				}
			}

			// 불가능 찾기
			boolean isEnd = false;

			// O가 더 많은 것 불가능
			if (cntO > cntX)
				isEnd = true;

			// 가세대 찾기
			if (!isEnd) {
				boolean flag = false;
				boolean winO = false;
				boolean winX = false;
				for (int i = 0; i < dis.length; i++) {
					if (str.charAt(dis[i].charAt(0) - '0') == str.charAt(dis[i].charAt(1) - '0')
							&& str.charAt(dis[i].charAt(1) - '0') == str.charAt(dis[i].charAt(2) - '0')
							&& str.charAt(dis[i].charAt(0) - '0') != '.') {
						if (str.charAt(dis[i].charAt(0) - '0') == 'O')
							winO = true;
						else
							winX = true;
						flag = true;
					}
				}
				// 다 안찼는데 가세대 없는것 불가능
				if (cntO + cntX < 9 && !flag)
					isEnd = true;
				if (flag) {
					// O가 맞췄는데 O == X 아닌 것 불가능
					if (winO && cntO != cntX)
						isEnd = true;
					// X가 맞췄는데 X = O+1 아닌 것 불가능
					if (winX && cntX != cntO + 1)
						isEnd = true;
				}
				// 다 차지 않았는데 둘 다 이기는거 불가능
				if (cntO + cntX != 9 && !(winO ^ winX))
					isEnd = true;
			}

			if (isEnd) {
				ans = "invalid\n";
			}
			bw.append(ans);
			str = br.readLine();
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
