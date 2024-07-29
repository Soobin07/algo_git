package beakjoon.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;

public class Q5397 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		LinkedList<Character> sb = new LinkedList<>();

		for (int n = 0; n < N; n++) {
			String str_ = br.readLine();
			sb.clear();
			ListIterator<Character> iter = sb.listIterator();

			for (char ch : str_.toCharArray()) {
				if (ch == '<') {
					if(iter.hasPrevious())
						iter.previous();
				} else if (ch == '>') {
					if(iter.hasNext())
						iter.next();
				} else if (ch == '-') {
					if(iter.hasPrevious()) {
						iter.previous();
						iter.remove();
					}
				} else {
					iter.add(ch);
				}
			}
			bw.append(sb.toString().replaceAll("[\\[\\], ]", "") + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
