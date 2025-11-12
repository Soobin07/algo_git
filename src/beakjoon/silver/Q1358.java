package src.beakjoon.silver;
import java.util.*;

public class Q1358 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int W = sc.nextInt();
        int H = sc.nextInt();
        int X = sc.nextInt();
        int Y = sc.nextInt();
        int P = sc.nextInt();

        int count = 0;
        double r = H / 2.0; // 반지름

        for (int i = 0; i < P; i++) {
            int px = sc.nextInt();
            int py = sc.nextInt();

            // 직사각형 내부
            if (X <= px && px <= X + W && Y <= py && py <= Y + H) {
                count++;
            } else {
                // 왼쪽 반원
                double leftCenterX = X;
                double leftCenterY = Y + r;
                double distLeft = Math.pow(px - leftCenterX, 2) + Math.pow(py - leftCenterY, 2);

                // 오른쪽 반원
                double rightCenterX = X + W;
                double rightCenterY = Y + r;
                double distRight = Math.pow(px - rightCenterX, 2) + Math.pow(py - rightCenterY, 2);

                if (distLeft <= r * r || distRight <= r * r) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
