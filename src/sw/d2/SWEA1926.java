package sw.d2;
import java.util.Scanner;

public class SWEA1926 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
        int n = sc.nextInt();
		for(int i = 1 ; i <= n ; i++){
			String str = Integer.toString(i);
			char[] arr = str.toCharArray();
			
			int count = 0;
			for(int j = 0 ; j < arr.length ; j++) {
				if(arr[j] == '3'||arr[j] == '6'||arr[j] == '9') {
					count++;
				}
			}
			
			if(count == 0) {
				sb.append(str).append(" ");
			}else {
				for(int j = 0 ; j < count ; j++) {
					sb.append('-');
				}
				sb.append(" ");
			}
        }
        System.out.println(sb);
	}
}
