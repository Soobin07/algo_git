package src.beakjoon.bronze;
import java.util.Scanner;

public class Q6502 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = 1;
        
        while (true) {
            int r = sc.nextInt();

            // r이 0이면 종료
            if (r == 0) {
                break;
            }
            
            int w = sc.nextInt();
            int l = sc.nextInt();
            
            // 피자의 대각선 길이 계산
            double diagonal = Math.sqrt(w * w + l * l);
            
            // 식탁의 지름 계산
            double tableDiameter = 2 * r;
            
            // 피자가 식탁에 올려질 수 있는지 확인
            if (diagonal <= tableDiameter) {
                System.out.println("Pizza "+cnt+" fits on the table.");
            } else {
                System.out.println("Pizza "+cnt+" does not fit on the table.");
            }
            cnt++;
        }
        
        sc.close();
    }
}
