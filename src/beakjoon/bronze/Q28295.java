pacakge src.beakjoon.bronze;
import java.util.Scanner;

public class Q28295 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 0=N, 1=E, 2=S, 3=W
        int dir = 0;

        for (int i = 0; i < 10; i++) {
            int cmd = sc.nextInt();
            if (cmd == 1) dir = (dir + 1) % 4;
            else if (cmd == 2) dir = (dir + 2) % 4;
            else if (cmd == 3) dir = (dir + 3) % 4;
        }

        char[] dirs = {'N', 'E', 'S', 'W'};
        System.out.println(dirs[dir]);
    }
}
