package beakjoon.bronze;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Q9086 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(sc.nextLine());
		for(int t = 0 ; t < T ; t++) {
			String str = sc.nextLine();
			bw.append(""+str.charAt(0)+str.charAt(str.length()-1)+"\n");
		}
		bw.flush();
		bw.close();
		sc.close();
	}
}
