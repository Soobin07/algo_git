package beakjoon.silver;

import java.util.Scanner;

public class Q2941 {
	public static void main(String[] args) {
		//해당하는 알파벳을 모두 한글자로 바꾼 후 길이 세기 
		Scanner sc = new Scanner(System.in);
		String[] alpha = {"c=", "c-","dz=","d-","lj","nj","s=","z="};

		String str = sc.nextLine();
		for(String apl : alpha) {
			if(str.contains(apl)) {
				str = str.replace(apl, "_");
			}
		}
		System.out.println(str +" "+str.length());
	}
}
