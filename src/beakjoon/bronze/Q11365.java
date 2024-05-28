package beakjoon.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//!밀비 급일
public class Q11365 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine();
		while (!str.equals("END")) {
			StringBuffer sb = new StringBuffer(str);
			bw.append(sb.reverse().toString()).append("\n");
			str = br.readLine();
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
