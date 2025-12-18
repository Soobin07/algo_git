package src.beakjoon.bronze;
import java.io.*;
import java.util.*;

public class Q2712 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Map<String, Double> factor = new HashMap<>();
        factor.put("kg", 2.2046);
        factor.put("lb", 0.4536);
        factor.put("l", 0.2642);
        factor.put("g", 3.7854);

        Map<String, String> toUnit = new HashMap<>();
        toUnit.put("kg", "lb");
        toUnit.put("lb", "kg");
        toUnit.put("l", "g");
        toUnit.put("g", "l");

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double value = Double.parseDouble(st.nextToken());
            String unit = st.nextToken();

            value *= factor.get(unit);
            unit = toUnit.get(unit);

            sb.append(String.format("%.4f %s\n", value, unit));
        }

        System.out.print(sb);
    }
}
