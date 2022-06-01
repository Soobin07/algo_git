package beakjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

//내 것 보다 좀 더 세련된 방식
public class Q17413_3 {
	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw=new PrintWriter(System.out);
		StringBuilder sb=new StringBuilder();
		
		String str=br.readLine();	//문장 받음
		int size=str.length();		//문장의 사이즈
		int start=0;		//아래에서 시작점으로 쓸 것
		int end=0;			//아래에서 끝점으로 쓸 것
		boolean tag=false;		//태그 안인지 확인용
		for(int i=0;i<size;i++) {	//문장 글자 크기로 for문
			char now=str.charAt(i);	//현재 글자
			
			if(now=='<') {	//현재 글자가 여는꺽쇠면
				for(int j=1;j<=i-start;j++) {	//이전 start부터 지금까지 캐릭터를 뒤에서부터 담아줌
					sb.append(str.charAt(i-j));
				}
				start=i+1;				//시작점 설정 (현재 다음것으로)
				tag=true;			//태그 안
			}
			if(tag) {		//태그면 그대로 저장
				sb.append(now);
			}
			if(now=='>') {	//태그 끝
				start=i+1;	//시작점 재시작	(현재 문자 다음 문자로)
				tag=false;	//태그 종료
				continue;
			}
			if(tag)				//왜있는지 모르겠어..
				continue;
			
			if(now==' ') {	//공백인 경우
				for(int j=1;j<=i-start;j++) {	//이전 start부터 지금까지 캐릭터를 뒤에서부터 담아줌
					sb.append(str.charAt(i-j));
				}
				sb.append(' ');	//공백 붙이기
				start=i+1;	//시작점 재시작
			}
		}
		if(start<size) {	//위에서 종료한 후 공백문자 못만나서 아직 남은 글자들을 돌려서 넣어줄 용도
			for(int i=size-1;i>=start;i--) {	//돌려서 넣어줌
				sb.append(str.charAt(i));
			}
		}
		
		pw.print(sb);
		br.close();
		pw.flush();
		pw.close();
	}
}
