package beakjoon.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Q2857 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();

		Pattern p = Pattern.compile("([A-Z]|[-]|[0-9]){0,10}");
		for (int i = 1; i <= 5; i++) {
			String str = br.readLine();
			Matcher m = p.matcher(str);
			if (m.matches() & str.contains("FBI"))
				sb.append(i + " ");
		}

		if (sb.length() == 0)
			sb.append("HE GOT AWAY!");
		else
			sb.setLength(sb.length() - 1);

		bw.append(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
