package beakjoon.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Q7785 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		HashSet<String> company = new HashSet<>();

		int N = Integer.parseInt(br.readLine());
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			if (st.nextToken().equals("enter")) {
				company.add(name);
			} else if (company.contains(name)) {
				company.remove(name);
			}
		}

		String[] str = company.toArray(new String[0]);
		Arrays.sort(str);
		for (int i = 0; i < str.length; i++) {
			bw.append(str[str.length - i - 1] + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
