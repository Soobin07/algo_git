package beakjoon.bronze;

import java.util.Scanner;

public class Q5622 {
	public static void main(String[] args) {
		//옛날전화기, 전화번호를 누를 때 걸리는 시간
		//알파벳이 어느 번호에 들어가는지 안 후, 알맞은 시간을 더해줬다.
		Scanner sc = new Scanner(System.in);
		String word = sc.nextLine();
		int time = 0;
		for(int i = 0 ; i < word.length() ; i++) {
			char ch = word.charAt(i);
			if(ch >= 'A' && ch <= 'C') time +=3;
			else if(ch <= 'F') time +=4;
			else if(ch <= 'I') time +=5;
			else if(ch <= 'L') time +=6;
			else if(ch <= 'O') time +=7;
			else if(ch <= 'S') time +=8;
			else if(ch <= 'V') time +=9;
			else if(ch <= 'Z') time +=10;
		}
		System.out.println(time);
	}
}
