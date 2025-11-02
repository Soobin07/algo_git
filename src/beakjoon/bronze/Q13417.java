package src.beakjoon.bornze;

import java.util.*;
import java.io.*;

public class Q13417 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine()); // 카드 개수
            String[] arr = br.readLine().split(" ");  // 카드 문자 배열

            Deque<Character> deque = new LinkedList<>();
            deque.add(arr[0].charAt(0));  // 첫 글자 삽입

            for (int i = 1; i < N; i++) {
                char c = arr[i].charAt(0);
                if (c <= deque.peekFirst()) {
                    deque.addFirst(c);
                } else {
                    deque.addLast(c);
                }
            }

            // deque의 내용을 문자열로 합침
            for (char ch : deque) {
                sb.append(ch);
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}
