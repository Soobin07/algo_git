package beakjoon.silver;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Q4659 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		StringBuffer ans = new StringBuffer();
		Pattern pattern = Pattern.compile("^[^aieou]+$");
		Matcher matcher;
		outer: while (true) {
			String tmp = sc.nextLine();
			// 마지막은 end다
			if (tmp.equals("end"))
				break;

			// 1. aieou 하나 반드시 포함
			if (pattern.matcher(tmp).find()) {
				ans.append("<" + tmp + "> is not acceptable.\n");
				continue outer;
			}
			// 2. 모음이 3개 혹은 자음이 3개 연속으로 오면 안된다
			int cnt = 0;
			boolean isCons = true;
			for (int i = 0; i < tmp.length(); i++) {
				if ("aieou".contains(tmp.charAt(i) + "")) {
					if (!isCons)
						cnt++;
					else {
						cnt = 1;
						isCons = false;
					}
				} else {
					if (isCons)
						cnt++;
					else {
						cnt = 1;
						isCons = true;
					}
				}
				if (cnt == 3) {
					ans.append("<" + tmp + "> is not acceptable.\n");
					continue outer;
				}
			}

			char ch = '\u0000';
			cnt = 0;
			// 3. 같은 글자가 연속적으로 두번 오면 안되나 ee와 oo는 허용한다
			for (int i = 0; i < tmp.length(); i++) {
				if (tmp.charAt(i) == ch) {
					if (ch != 'e' && ch != 'o') {
						ans.append("<" + tmp + "> is not acceptable.\n");
						continue outer;
					}
				} else {
					ch = tmp.charAt(i);
				}
			}

			ans.append("<" + tmp + "> is acceptable.\n");
		}
		ans.setLength(ans.length() - 1);
		System.out.println(ans.toString());
	}
}
