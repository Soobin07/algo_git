package beakjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

//iterator에 prev도 있다
//list-iterator은 양방향 탐색, 요소추가삭제 가능
//iterator은 단방향 탐색, 조회만 가능
public class Q1406_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		LinkedList<Character> list = new LinkedList<>();
		
		String first = br.readLine();
		for(int i = 0 ; i < first.length() ; i++) {
			list.addLast(first.charAt(i));
		}
		
		int M = Integer.parseInt(br.readLine());
		ListIterator<Character> iter = list.listIterator();
		while(iter.hasNext()) iter.next();
		
		for(int i = 0 ; i < M ; i++) {
			String line = br.readLine();
			char co = line.charAt(0);
			if(co == 'P') {
				char write = line.charAt(2);
				iter.add(write);
			}
			if(co == 'L' && iter.hasPrevious()) {
				iter.previous();
			}
			if(co == 'D' && iter.hasNext()) {
				iter.next();
			}
			if(co == 'B' && iter.hasPrevious()) {
				iter.previous();
				iter.remove();
			}
		}
		StringBuffer sb = new StringBuffer();
		iter = list.listIterator();
		while(iter.hasNext()) {
			sb.append(iter.next());
		}
		System.out.println(sb.toString());
	}
}
