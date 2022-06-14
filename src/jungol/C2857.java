package jungol;

import java.util.Scanner;

public class C2857 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[][] map = new char[5][];
		int biggest = 0;
		for(int i = 0 ; i < 5 ; i++) {//원래
			String str = sc.nextLine();
			map[i] = str.toCharArray();
			biggest = Math.max(biggest, str.length());
		}
		for(int i = 0 ; i < biggest ; i++){
			for(int j = 0 ; j < 5 ; j++) {
				if(i < map[j].length) System.out.print(map[j][i]);
			}
		}
	}
}
