package beakjoon.bronze;

import java.util.Scanner;

public class Q1333 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 노래 개수
        int L = sc.nextInt(); // 각 노래 길이
        int D = sc.nextInt(); // 전화벨 간격
        
        int time = 0; 
        int songEnd = N * (L + 5) - 5;

        while (time <= songEnd) {
            if ((time % (L + 5)) >= L) {
                System.out.println(time);
                return;
            }
            time += D;
        }

        System.out.println(time);
    }
}