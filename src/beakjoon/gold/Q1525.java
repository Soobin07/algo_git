package beakjoon.gold;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

//22%에서 오류. 다시
//6 4 7
//8 5 0
//3 2 1	//이게 31이 나와야 한다
public class Q1525 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int st = 123456780;
		Set<Integer> set = new HashSet<>();
		StringBuffer sb = new StringBuffer();

		// 받은 배열 숫자로 정리해보기
		int oriPuz = 0;
		for (int i = 0; i < 9; i++) {
			oriPuz *= 10;
			oriPuz += sc.nextInt();
		}
		int[] ori = { oriPuz, 0 }; // 배열, 몇번 움직임
		set.add(oriPuz);	//여지껏 나온 수 확인 (같은거 무한 반복 막으려고)

		Queue<int[]> queue = new LinkedList<>();
		queue.add(ori);	//확인할 숫자 넣기

		int[] curr;

		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		find : while (true) {
			if(queue.isEmpty()) {
				curr = new int[] {0, -1};
				break;
			}
			
			curr = queue.poll();
			if (curr[0] == st)
				break; // 같으면 멈춰

			// 0 찾기
			int r = 0;
			int c = 0;
			char[] tmpCharArr = (String.valueOf(curr[0])).toCharArray();
			if (tmpCharArr.length == 9) {
				int i = String.valueOf(curr[0]).indexOf('0');
				r = i / 3;
				c = i % 3;
			}else {
				char[] tmp = new char[9];
				tmp[0] = '0';
				System.arraycopy(tmpCharArr, 0, tmp, 1, 8);
				tmpCharArr = tmp;
			}

			// 0 근처 숫자 바꾼거 queue에 넣기
			for (int i = 0; i < 4; i++) {
				char[] arr = Arrays.copyOf(tmpCharArr, tmpCharArr.length);
				int idx = (r + dr[i]) * 3 + (c + dc[i]);
				if(idx >= arr.length || idx < 0) continue;
				char ch = arr[idx];
				arr[r*3+c] = ch;
				arr[idx] = '0';
				sb.setLength(0);
				sb.append(arr);
				int tmp = Integer.parseInt(sb.toString());
				if(!set.contains(tmp)) {
					set.add(tmp);
					queue.add(new int[] {tmp,curr[1]+1});
				}
			}
		}
		System.out.println(curr[1]);
	}
}
