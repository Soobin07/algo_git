package beakjoon.bronze;

import java.util.Scanner;

public class Q9094 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스 개수
        
        for (int tc = 0; tc < T; tc++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int count = 0;
            
            // 0 < a < b < n
            for (int a = 1; a < n; a++) {
                for (int b = a + 1; b < n; b++) {
                    // 조건: (a² + b² + m)가 (a * b)로 나누어 떨어지는지
                    if ((a * a + b * b + m) % (a * b) == 0) {
                        count++;
                    }
                }
            }
            
            System.out.println(count);
        }
    }
}
