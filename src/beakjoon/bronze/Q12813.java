package src.beakjoon.bronze;

import java.util.*;
import java.io.*;

class Q12813 {
    public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int max = 100_000;
       
       char[] A = br.readLine().toCharArray();
       char[] B = br.readLine().toCharArray();
       
       StringBuffer and = new StringBuffer();
       for(int i = 0 ; i < max ; i++ ){
           and.append(A[i] == '1' && B[i] == '1' ? '1':'0');
       }
       StringBuffer or = new StringBuffer();
       for(int i = 0 ; i < max ; i++ ){
           or.append(A[i] == '1' || B[i] == '1' ? '1':'0');
       }
       StringBuffer xor = new StringBuffer();
       for(int i = 0 ; i < max ; i++ ){
           xor.append(A[i] == B[i] ? '0':'1');
       }
       StringBuffer nota = new StringBuffer();
       for(int i = 0 ; i < max ; i++ ){
           nota.append(A[i]=='0'?'1':'0');
       }
       StringBuffer notb = new StringBuffer();
       for(int i = 0 ; i < max ; i++ ){
           notb.append(B[i]=='0'?'1':'0');
       }
       
       System.out.println(and.toString());
       System.out.println(or.toString());
       System.out.println(xor.toString());
       System.out.println(nota.toString());
       System.out.println(notb.toString());
    }
}
