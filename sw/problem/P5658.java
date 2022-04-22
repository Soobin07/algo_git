package sw.problem;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class P5658 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		
		int n, k;
        String tmp;
        Set<String> strArr;
        String[] strTmpArr;
        for(int test_case = 1; test_case <= T; test_case++)
		{
            tmp = sc.nextLine();
			n = Integer.parseInt(tmp.split(" ")[0]);
            k = Integer.parseInt(tmp.split(" ")[1]);
            tmp = sc.nextLine();
            strArr = new HashSet<>();
            
            for(int i = 0 ; i < n/4 ; i++) {
            	for(int j = 0 ; j < 4 ; j++) {
            		if((j+1)*(n/4) >= n) {
            			strArr.add(tmp.substring(j*(n/4)));
            		}else {
            			strArr.add(tmp.substring(j*(n/4), (j+1)*(n/4)));
            		}
            	}
            	tmp = tmp.substring(1).concat(tmp.charAt(0)+"");
            }
            strTmpArr = strArr.toArray(new String[0]);
            Arrays.sort(strTmpArr, Collections.reverseOrder());
            
            tmp = strTmpArr[k-1];
            System.out.println("#"+test_case+" "+Integer.parseInt(tmp,16));
            
		}
        
        sc.close();
	}
}
