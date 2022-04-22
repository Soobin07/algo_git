package programmers.level2;

import java.util.Arrays;

//효율성 3,4 실패.. phone_book.length <= 1,000,000 이다.
//2중 for문은 효율성이 떨어진다.

public class P42577_2 {
	public static void main(String[] args) {
		String[] phone_book = {"119", "97674223", "1195524421"};
		
		System.out.println(answer(phone_book));
		
	}
	static boolean answer(String[] phone_book) {
		Arrays.sort(phone_book);
		System.out.println(Arrays.toString(phone_book));
		
		
		
        for (int i = 0; i < phone_book.length - 1; i++){        
            if (phone_book[i + 1].startsWith(phone_book[i])){	//바로 직전것과 비교.. 아니면 넘어감  why?
            													//String의 sort!!!!! 119 > 1195524421 순..
                return false;
            }
        }
        return true;
	}
	static boolean find(String[] phone_book) {
		Arrays.sort(phone_book);
		
		String str = "";
		for(int i = 0 ; i < phone_book.length-1 ; i++) {
			for(int j = i+1 ; j < phone_book.length ; j++) {
				if(phone_book[j].startsWith(str)) {
					System.out.println(str+" "+phone_book[j]);
					return false;
				}
			}
		}
		return true;
	}
}
