package programmers.level1;

import java.util.Arrays;

//효율성 0점 ㅠㅠ
public class P42576_2 {
	public static void main(String[] args) {
		String[] participant = {"leo", "kiki", "eden"}; 
		String[] completion = {"eden", "kiki"};
		
		Arrays.sort(participant);	//알파벳순 정렬
        Arrays.sort(completion);	//알파벳순 정렬
        int i;						//completion.length를 밖으로 빼기 위해 사용(아래 값이 없는 경우 completion.length가 답이니까)
        for(i = 0; i<completion.length; i++){		//앞에서부터 동일한 것을 뺀다
            if(!participant[i].equals(completion[i])){	//동일하지 않을때
                System.out.println(participant[i]);		//그 값을 리턴
            }
        }
        System.out.println(participant[i]);	//마지막 값을 리턴
	}
}
