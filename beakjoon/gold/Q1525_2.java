package beakjoon.gold;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

//22%에서 오류. 다시
//6 4 7
//8 5 0
//3 2 1	//이게 31이 나와야 한다

//문제였던 곳 : 다 좋은데, 3*3배열에서 잘못 생각했다. r과 c를 분리해서 생각했어야 했는데, 이미 합친 idx를 두고 생각을 해서 더 많은 경우를 '가능하게' 만들었다.
public class Q1525_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();

		String answer = "123456780";
		Map<String, Integer> visit = new HashMap<>();

		// 받은 배열 문자로 정리
		for (int i = 0; i < 9; i++) {
			sb.append(sc.next());
		}
		visit.put(sb.toString(), 0); // 배열, 몇번 움직임

		Queue<String> queue = new LinkedList<>();
		queue.add(sb.toString());	//확인할 숫자 넣기

		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		
		int ans = -1;
		while (true) {
			if(queue.isEmpty()) {
				break;
			}
			String checkStr = queue.poll();
			
			if (checkStr.equals(answer)) {
				ans = visit.get(checkStr);
				break ; // 같으면 멈춰
			}
			
			// 0 찾기
			int index = checkStr.toString().indexOf('0');
			int r = index/3;
			int c = index%3;

			// 0 근처 숫자 바꾼거 queue에 넣기
			for (int i = 0; i < 4; i++) {
				int tmpR = r + dr[i];
				int tmpC = c + dc[i];

				if(tmpR < 0 || tmpC < 0 || tmpR > 2 || tmpC > 2) continue;
				
				char tmpCh = checkStr.charAt(tmpR*3+tmpC);
				String tmpStr = checkStr.replace(tmpCh, 'c');
				tmpStr = tmpStr.replace('0', tmpCh);
				tmpStr = tmpStr.replace('c', '0');
				
				if(!visit.containsKey(tmpStr)) {
					queue.add(tmpStr);
					visit.put(tmpStr, visit.get(checkStr)+1);
				}
			}
		}
		System.out.println(ans);
	}
}
