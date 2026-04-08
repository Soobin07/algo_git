package src.beakjoon.bronze;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Q9501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine()); 
        
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int N = Integer.parseInt(st.nextToken()); 
            double P = Double.parseDouble(st.nextToken()); 
            
            int count = 0;
            
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                
                double v = Double.parseDouble(st.nextToken()); 
                double f = Double.parseDouble(st.nextToken()); 
                double c = Double.parseDouble(st.nextToken()); 
                
                if ((P / v) * c <= f) {
                    count++;
                }
            }
            
            System.out.println(count);
        }
    }
}
