package beakjoon.bronze;

import java.util.Scanner;

public class Q1924 {
	public static void main(String[] args) {
		//달을 모두 일로 바꿔 더한 다음, 7로 나누어 0이 나오면 일요일 (1.1이 월요일이니까)
		
		Scanner sc = new Scanner(System.in);
		String[] yoil = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
		
		int month = sc.nextInt();
		int day = sc.nextInt();
		switch(month) {
		case 12 : day += 30; 
		case 11 : day += 31;
		case 10 : day += 30;
		case 9 : day += 31;
		case 8 : day += 31;
		case 7 : day += 30;
		case 6 : day += 31;
		case 5 : day += 30;
		case 4 : day += 31;
		case 3 : day += 28;
		case 2 : day += 31;
		}
		System.out.println(yoil[day%7]);
	}
}
