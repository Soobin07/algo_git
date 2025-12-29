package src.beakjoon.bronze;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q22341 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int A = N; 
        int B = N; 

        for (int i = 0; i < C; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            if (X >= A || Y >= B) continue;

            long areaHorizontal = (long) X * B; 
            long areaVertical = (long) A * Y;  

            if (areaVertical > areaHorizontal) {
                B = Y;
            } else {
                A = X; 
            }
        }

        System.out.println((long) A * B);
    }
}
