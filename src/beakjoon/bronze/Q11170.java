package beakjoon.bronze;

import java.util.Scanner;

public class Q11170 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스 개수

        while (T-- > 0) {
            long A = sc.nextLong();
            long B = sc.nextLong();
            // A와 B의 순서 보장 (A <= B)
            if (A > B) {
                long temp = A;
                A = B;
                B = temp;
            }

            long result = 0;
            // 범위에 0이 포함되면, '0' 자체에 포함된 0 1개 추가
            if (A == 0) {
                result = 1;
            }

            // 1부터 B까지의 0의 개수를 계산 (countB)
            long countB = 0;
            long n = B;
            for (long i = 1; i <= n; i *= 10) {
                long high = n / (i * 10);
                long cur  = (n / i) % 10;
                long low  = n % i;
                if (cur == 0) {
                    countB += (high - 1) * i + (low + 1);
                } else {
                    countB += high * i;
                }
            }

            // 1부터 A-1까지의 0의 개수를 계산 (countA)
            long countA = 0;
            n = A - 1;
            if (n > 0) {
                for (long i = 1; i <= n; i *= 10) {
                    long high = n / (i * 10);
                    long cur  = (n / i) % 10;
                    long low  = n % i;
                    if (cur == 0) {
                        countA += (high - 1) * i + (low + 1);
                    } else {
                        countA += high * i;
                    }
                }
            }

            result += (countB - countA);
            System.out.println(result);
        }

        sc.close();
    }
}