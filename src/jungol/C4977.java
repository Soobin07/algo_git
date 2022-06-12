package jungol;

import java.util.Scanner;

public class C4977 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String[] strArr = str.split("\\.");
		System.out.print(Integer.toBinaryString(Integer.parseInt(strArr[0])));
		StringBuffer sb = new StringBuffer();
		if(strArr.length == 2) {
			double d = Double.parseDouble(str) % 1;
			int cnt = 0;
			while(d != 0) {
				cnt++;
				d*=2;
				sb.append((int)(d-d%1));
				d = d % 1;
				if(cnt == 4) break;
			}
			for(int i = cnt ; i < 4 ; i++) {
				sb.append("0");
			}
		}
		System.out.printf(".%4s",sb.toString());
	}
}
