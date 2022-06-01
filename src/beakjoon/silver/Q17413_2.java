package beakjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//처음부터 문자열을 문자의 배열로 받고, 리버스 할 곳을 바꿔주는 내용
public class Q17413_2 {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static char[] chars;
    public static void main(String[] args) throws Exception {
        chars = reader.readLine().toCharArray();		//charArray 로 바꿈

        int idx = 0;	//chars의 idx 찾는듯
        while (idx<chars.length) {	//chars 배열 끝을 볼때 까지
            if (chars[idx] == '<') {	//< 나오면
                while(chars[idx++]!='>') {}	//> 나올 때 까지 그냥 idx 추가해줘
            } else if (Character.isLetterOrDigit(chars[idx])) {	//숫자, 문자일 경우 통과
            	int start = idx;	//시작 idx 찾기
                while (idx < chars.length && chars[idx] != '<' && chars[idx] != ' ') {	//idx가 문자 끝까지 가지 전, 그리고 chars[idx]가 닫는 태그가 아닐 때, 공백이 아닐 때
                    idx++;	//idx 추가
                }
                int end = idx-1;	//끝나는 인덱스 찾기
                reverse(chars, start, end);	//메소드

                if(idx<chars.length && chars[idx]!='<') {
                    idx++;
                }
            }
        }

        System.out.println(chars);
    }

    static void reverse(char[] chars, int start, int end) {	//chars를 반대로
        while (start<end) {	//start가 더 앞에 있을 때
            char tmp = chars[start];	//시작점 과 끝점 바꿈
            chars[start] = chars[end];
            chars[end] = tmp;

            start++;		//시작점 한칸 뒤로
            end--;			//끝점 한칸 앞으로
        }
    }
}
