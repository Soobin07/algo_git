package programmers.level2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//효율성 테스트가 없다..?!
public class P42578 {
	public static void main(String[] args) {
		String[][] clothes = {{"yellowhat", "headgear"},{"bluesunglasses", "eyewear"},{"green_turban", "headgear"}};
//		System.out.println(solution(clothes));
//		System.out.println(solution2(clothes));
		
	}

	//1. 같은 j끼리 모은다
	//2. 각 숫자 +1 을 모두 곱하고 아무것도 걸치지 않는 경우 1을 뺀다. (1을 더하는 이유 : 안걸칠 경우가 있기 때문) 
	static int solution(String[][] clothes) {
		int answer = 1;
		Set<String> set = new HashSet<>();
		for(int i = 0 ; i < clothes.length ; i++) {
			set.add(clothes[i][1]);
		}
		String[] list = set.toArray(new String[0]);
		int[] len = new int[set.size()];
		for(int i = 0 ; i < list.length; i++) {
			for(int j = 0 ; j < clothes.length ; j++) {
				if(list[i].equals(clothes[j][1])) {
					len[i]++;
				}
			}
		}
		
		for(int i = 0 ; i < len.length ; i++){
			answer *= (len[i]+1);
		}
		
		return answer-1;
	}
}
