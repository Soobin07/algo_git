package beakjoon.silver;

import java.util.Scanner;
public class Q17413 {
	static String input1 = "baekjoon online judge";	//noojkeab enilno egduj
	static String input2 = "<open>tag<close>";	//<open>gat<close>
	static String input3 = "<ab cd>ef gh<ij kl>";	//<ab cd>fe hg<ij kl>
	static String input4 = "one1 two2 three3 4fourr 5five 6six";	//1eno 2owt 3eerht rruof4 evif5 xis6
	static String input5 = "<int><max>2147483647<long long><max>9223372036854775807";	//<int><max>7463847412<long long><max>7085774586302733229
	static String input6 = "<problem>17413<is hardest>problem ever<end>"; //<problem>31471<is hardest>melborp reve<end>
	static String input7 = "<   space   >space space space<    spa   c e>";	//<   space   >ecaps ecaps ecaps<    spa   c e>

	
	static String input8 = "baekjoon  algorithm";
	static String input9 = "b<aekjoo>n algorithm";
	public static void main(String[] args) {
		Scanner sc = new Scanner(input8);
//		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		String ori = sc.nextLine();
		boolean flag = false;
		StringBuffer tmp = new StringBuffer();
		for(int i = 0 ; i < ori.length() ; i++) {
			char ch = ori.charAt(i);
			if(ch == '<') {	//태그 열어줌
				if(tmp.length() != 0) {
					sb.append(tmp.reverse().toString());
					tmp=new StringBuffer();
				}
				sb.append(ch);
				flag = true;
				continue;
			}
			if(ch == '>') {	//태그 닫아줌
				sb.append(ch);
				flag = false;
				continue;
			}
			if(flag) {	//태그 안 글자
				sb.append(ch);
				continue;
			}
			
			if(ch == ' ') {	//단어 종료
				sb.append(tmp.reverse().append(" ").toString());
				tmp=new StringBuffer();
				continue;
			}
			//태그 밖 글자
			tmp.append(ch);
		}
		if(tmp.length() != 0) {
			sb.append(tmp.reverse().toString());
			tmp=new StringBuffer();
		}
		
		System.out.println(sb.toString());
	}
}
