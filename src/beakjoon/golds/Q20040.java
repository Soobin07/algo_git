package src.baekjoon.golds;

import java.util.*;
import java.io.*;

class Q20040 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] lines = new int[N];
        
        for(int i = 0 ; i < N ; i++){
            lines[i] = i;
        }
        
        int ans = 0;
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            if(getParent(s, lines) == getParent(e, lines)){
                ans = i+1;
                break;
            }
            if(getParent(s, lines) > getParent(e, lines)){
                setParent(s, getParent(e, lines), lines);
            }else{
                setParent(e, getParent(s, lines), lines);
            }
        }
        System.out.println(ans);
    }
    public static int getParent(int a, int[] arr){
        if(arr[a] == a) return a;
        return getParent(arr[a], arr);
    }
    
    public static void setParent(int a, int b, int[] arr){
        if(arr[a] == a){
            arr[a] = b;
            return;
        }
        if(arr[a] == b) return;
        setParent(arr[a], b, arr);
    }
}
