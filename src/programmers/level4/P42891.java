package programmers.level4;

//정확도 100, 효율성 0..
public class P42891 {
	public static void main(String[] args) {
		// solution에 넣는다 int[] food_times, long k를
	}

	public int solution(int[] food_times, long k) {
		// 몇번째 음식을 먹을 차례인가
		int answer = 0;
		// 음식이 몇가지가 있는가
		int N = food_times.length;
		// 음식을 다 먹었는가
		boolean[] fin = new boolean[N];
		for (int i = 0; i < N; i++) {
			if (food_times[i] == 0) {
				fin[i] = true;
			}
		}

		// k번 먹는다
		for (long i = 0; i < k; i++) {
			answer = eatIdx(food_times, answer, fin);
			if (answer == -1)
				return -1;
			eat(answer, food_times, fin);
			answer++;
		}

		System.out.println("here is fin");
		for (int i = 0; i < fin.length; i++) {
			System.out.print(fin[i] + " ");
		}

		// 우리는 음식을 0번부터, 답은 1번부터 요구하니까 +1 해준다
		answer = eatIdx(food_times, answer, fin);
		return answer == -1 ? -1 : answer + 1;
	}

	// 먹을 음식, 시작 idx, 먹을 수 있는지를 넣으면 이번에 먹을 음식의 idx 나옴
	public int eatIdx(int[] foods, int start, boolean[] fin) {
		for (int i = 0; i < foods.length; i++) {
			if (fin[(start + i) % foods.length])
				continue;
			return (start + i) % foods.length;
		}
		return -1;
	}

	// 먹음
	public void eat(int idx, int[] foods, boolean[] fin) {
		foods[idx]--;
		if (foods[idx] == 0)
			fin[idx] = true;
	}
}
