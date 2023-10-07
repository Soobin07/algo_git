package beakjoon.golds;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q1013 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		String ptn = "(100+1+|01)+";
		for(int n = 0 ; n < N ; n++) {
			String str = br.readLine().trim();
			bw.append(str.matches(ptn)?"YES\n":"NO\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
