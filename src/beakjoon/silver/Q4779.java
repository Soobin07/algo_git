package beakjoon.silver;

import java.util.Scanner;

//난 만들어서 잘랐는데...
//다른 사람들은 처음부터... 만들 부분만 만들었네.(*3을 했네)
public class Q4779 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			int N = Integer.parseInt(sc.nextLine());
			String line = makeLine(N);
			System.out.println(cutLine(line));
		}
	}

	static String makeLine(int N) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < Math.pow(3, N); i++) {
			sb.append('-');
		}
		return sb.toString();
	}

	static String cutLine(String line) {
		if(maxLineLength(line) == 1) {
			return line;
		}
		
		String line1 = line.substring(0, line.length()/3);
		String line3 = line.substring((line.length()*2)/3, line.length());
		StringBuffer line2 = new StringBuffer();
		for(int i = 0 ;i < line.length()/3 ; i++) {
			line2.append(" ");
		}
		
		return cutLine(line1)+line2.toString()+cutLine(line3);
	}

	static int maxLineLength(String line) {
		int max = 0;
		int cont = 0;
		for (int i = 0; i < line.length(); i++) {
			if(line.charAt(i) == '-') {
				cont++;
			}else {
				max = Math.max(max, cont);
			}
		}
		max = Math.max(max, cont);
		return max;
	}
}
