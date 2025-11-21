package src.beakjoon.bronze;
import java.util.Scanner;

public class Q33612 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();  // N번째 피갤컵
        
        int startYear = 2024;  // 제1회 연도
        int startMonth = 8;    // 제1회 월
        int interval = 7;      // 7개월 주기
        
        // 총 월 수 계산
        int totalMonths = (startYear - 1) * 12 + (startMonth - 1) + (N - 1) * interval;
        
        // 연도와 월 계산
        int newYear = totalMonths / 12 + 1;
        int newMonth = totalMonths % 12 + 1;
        
        System.out.println(newYear + " " + newMonth);
    }
}
