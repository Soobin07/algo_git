package src.beakjoon.silver;

import java.io.*;
import java.util.*;

public class Q2852 {
    private static int toSec(String t) {
        int m = Integer.parseInt(t.substring(0, 2));
        int s = Integer.parseInt(t.substring(3, 5));
        return m * 60 + s;
    }

    private static String toTime(int sec) {
        int m = sec / 60;
        int s = sec % 60;
        return String.format("%02d:%02d", m, s);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int score1 = 0, score2 = 0;
        int lead1 = 0, lead2 = 0;
        int prev = 0;   // 이전 득점 시각

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int team = Integer.parseInt(input[0]);
            int curr = toSec(input[1]);

            // prev → curr 구간 리드 팀 반영
            if (score1 > score2) {
                lead1 += (curr - prev);
            } else if (score2 > score1) {
                lead2 += (curr - prev);
            }

            // 이번 득점 반영
            if (team == 1) score1++;
            else score2++;

            prev = curr;
        }

        // 경기 종료(48:00 = 2880초)까지 계산
        int end = 48 * 60;
        if (score1 > score2) {
            lead1 += (end - prev);
        } else if (score2 > score1) {
            lead2 += (end - prev);
        }

        // 출력
        System.out.println(toTime(lead1));
        System.out.println(toTime(lead2));
    }
}
