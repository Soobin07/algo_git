package sw.d1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SWEA2063 {
	public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //br.read() -> 한글자씩 읽어 아스키코드로 반환한다.
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
         
        int[] array = new int[N];
        int index = 0;
        while(st.hasMoreTokens()){
            array[index++] = Integer.parseInt(st.nextToken());
        }
         
        for(int i = 0 ; i < N/2+1 ; i++){
            index = i;
            for(int j = i+1 ; j < N ; j++){
                if(array[index] > array[j]) index = j;
            }
            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
         
        System.out.println(array[N/2]);
    }
}
