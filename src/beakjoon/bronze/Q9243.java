package src.beakjoon.bronze;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // N: 덮어쓴 횟수
        int N = Integer.parseInt(br.readLine().trim());
        
        // before, after 비트 문자열
        String before = br.readLine().trim();
        String after  = br.readLine().trim();
        
        // 결과 저장 플래그
        boolean success = true;
        
        // N이 짝수일 경우
        if (N % 2 == 0) {
            if (!before.equals(after)) {
                success = false;
            }
        } 
        // N이 홀수일 경우
        else {
            int len = before.length();
            for (int i = 0; i < len; i++) {
                // before의 비트와 after의 비트가 같으면 실패
                if (before.charAt(i) == after.charAt(i)) {
                    success = false;
                    break;
                }
            }
        }
        
        // 출력
        if (success) {
            System.out.println("Deletion succeeded");
        } else {
            System.out.println("Deletion failed");
        }
    }
}
