package src.beakjoon.bronze;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q25703 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println("int a;");

        for (int i = 1; i <= N; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append("int ");

            // '*' i개
            for (int j = 0; j < i; j++) {
                sb.append("*");
            }

            // 변수 이름
            if (i == 1) {
                sb.append("ptr = &a;");
            } else if(i == 2){
                sb.append("ptr2 = &ptr;");
            }else {
                sb.append("ptr").append(i)
                  .append(" = &ptr").append(i - 1).append(";");
            }

            System.out.println(sb.toString());
        }
    }
}
