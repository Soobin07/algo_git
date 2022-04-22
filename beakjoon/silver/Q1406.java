package beakjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

//시간초과
public class Q1406 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		LinkedList<Character> list = new LinkedList<>();
		
		String first = br.readLine();
		int cursor = first.length();	//해당번째 요소에 있다 커서가
		for(int i = 0 ; i < first.length() ; i++) {
			list.addLast(first.charAt(i));
		}
		
		int M = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < M ; i++) {
			String line = br.readLine();
			char co = line.charAt(0);
			if(co == 'P') {
				char write = line.charAt(2);
				list.add(cursor, write);
				cursor++;
				continue;
			}
			if(co == 'L' && cursor > 0) {
				cursor--;
				continue;
			}
			if(co == 'D' && cursor < list.size()) {
				cursor++;
				continue;
			}
			if(co == 'B' && cursor > 0) {
				list.remove(cursor-1);
				cursor--;
				continue;
			}
		}
		StringBuffer sb = new StringBuffer();
		for(char c : list) {
			sb.append(c);
		}
		System.out.println(sb.toString());
	}
}
