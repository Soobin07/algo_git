package beakjoon.bronze;

import java.util.Scanner;

public class Q1259 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = "";
		boolean istrue = true;
		while(!str.equals("0")) {
			str = sc.nextLine();
			istrue = true;
			for(int i = 0 ; i < str.length()/2 ; i++) {
				if(str.charAt(i) != str.charAt(str.length()-1-i)) {
					istrue = false;
				}
			}
			if(!str.equals("0")) {
				if(istrue) System.out.println("yes");
				else System.out.println("no");
			}
		}
	}
}
