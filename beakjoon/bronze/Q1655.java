package beakjoon.bronze;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//맞는데 시간초과
public class Q1655 {
	public static void main(String[] args) {
		//정수 하나 input > 중간값 output
		//짝수일 경우 두 수중 작은 수
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //몇개의 케이스
		List<Integer> list = new ArrayList<>();
		for(int i = 0 ; i < n ; i++) {
			list.add(sc.nextInt());
			Collections.sort(list);
			System.out.println(list.get((list.size()-1)/2));
		}
	}

}
