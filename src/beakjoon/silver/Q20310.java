package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//타노스
public class Q20310 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		int cnt_z = 0; // 0 카운트
		int cnt_o = 0; // 1 카운트
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '0') {
				cnt_z++;
			} else {
				cnt_o++;
			}
		}

		StringBuffer sb = new StringBuffer(str);
		int tmp_z = cnt_z;
		int tmp_o = cnt_o;
		for (int i = 0; i < sb.length(); i++) {
			if (tmp_o <= cnt_o / 2) {
				break;
			}
			if (sb.charAt(i) == '1') {
				sb.deleteCharAt(i);
				tmp_o--;
				i--;
			}
		}
		for (int i = sb.length() - 1; i >= 0; i--) {
			if (tmp_z <= cnt_z / 2) {
				break;
			}
			if (sb.charAt(i) == '0') {
				sb.deleteCharAt(i);
				tmp_z--;
			}
		}

		System.out.println(sb.toString());
	}
}
