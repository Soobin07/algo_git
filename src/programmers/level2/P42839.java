package programmers.level2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//2, 10, 11, 12 실패
public class P42839 {
	static String[] numberArr;
	static boolean[] visit;
	static Set<Integer> set;
	
	public static void main(String[] args) {

		//1. numbers string을 가져온다
		//2. string을 하나씩 나눈다
		//3. 각각 다른 수를 만든다 ==> 중복은? set? 
		//4. 만들어진 수가 소수인지 확인하고, 소수면 answer++
		
		Scanner sc = new Scanner(System.in);
		String numbers = sc.nextLine();					//numbers String
		int answer = 0;
		
		numberArr = numbers.split("");					//숫자 하나씩 나눔
		set = new HashSet<Integer>();					//만들어진 숫자 목록
		visit = new boolean[numberArr.length];			//visit
		
		function(0,"");
		
		for(int num : set) {
			if(isPrime(num)) {
				answer++;
			}
		}
		
		System.out.println(answer);
	}
	
	static void function(int count,String string) {
		if(count <= numberArr.length && !(string.equals(""))) {
			set.add(Integer.parseInt(string));
		}
		for(int i = 0 ; i < numberArr.length ; i++) {
			if(visit[i] == false) {
				visit[i] = true;
				function(count+1,string.concat(numberArr[i]));
				visit[i] = false;
			}
		}
		return;
	}
	
	static boolean isPrime(int num) {
		if(num < 2) return false;
		for(int i = 2 ; i < num ; i++) {
			if(num%i == 0) return false;
		}
		return true;
	}
}
