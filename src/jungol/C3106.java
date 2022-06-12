package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C3106 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		String str = null;
		
		while((str = br.readLine()) != null && !str.equals("0")) {
			st = new StringTokenizer(str);
			
			int A = Integer.parseInt(st.nextToken());
			String S1 = st.nextToken();
			int B = Integer.parseInt(st.nextToken());
			
			System.out.println(Long.toUnsignedString(Long.parseUnsignedLong(S1, A), B).toUpperCase());
		}
	}
}
