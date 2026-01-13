package src.beakjoon.bronze;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q3028 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
        boolean[] cup = new boolean[3];
        cup[0] = true; 

        String moves = br.readLine();

        for (int i = 0; i < moves.length(); i++) {
            char cmd = moves.charAt(i);
            switch (cmd) {
                case 'A':
                    // 1번 컵과 2번 컵 스왑
                    boolean tempA = cup[0];
                    cup[0] = cup[1];
                    cup[1] = tempA;
                    break;
                case 'B':
                    // 2번 컵과 3번 컵 스왑
                    boolean tempB = cup[1];
                    cup[1] = cup[2];
                    cup[2] = tempB;
                    break;
                case 'C':
                    // 1번 컵과 3번 컵 스왑
                    boolean tempC = cup[0];
                    cup[0] = cup[2];
                    cup[2] = tempC;
                    break;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (cup[i]) {
                System.out.println(i + 1);
                break;
            }
        }
    }
}
