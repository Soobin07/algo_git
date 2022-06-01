package beakjoon.silver;

import java.util.Scanner;

public class Q3085 {
	static String input1 = "3\r\n" + "CCP\r\n" + "CCP\r\n" + "PPC"; // 3
	static String input2 = "4\r\n" + "PPPP\r\n" + "CYZY\r\n" + "CCPY\r\n" + "PPCC"; // 4
	static String input3 = "5\r\n" + "YCPZY\r\n" + "CYZZP\r\n" + "CCPPP\r\n" + "YCYZC\r\n" + "CPPZZ"; // 4
	static String input4 = "4\r\n" + "CPCP\r\n" + "YZYZ\r\n" + "CCPC\r\n" + "ZYZY"; // 3
	static String input5 = "4\r\n" + "\r\n" + "CCCC\r\n" + "CCCC\r\n" + "CCCC\r\n" + "CCCC"; // 4
	static String input6 = "3\r\n" + "YCP\r\n" + "PZY\r\n" + "YYY"; // 3
	static String input7 = "3\r\n" + "\r\n" + "CPC\r\n" + "\r\n" + "YZY\r\n" + "\r\n" + "CPC"; // 2
	static String input8 = "40\r\n" + "YYYYYYYYYCYYYYYYYYYYYYYYYCZZZZZZZYYYYYZC\r\n"
			+ "PYPCYZCPYCZZCCPZYYPZYYYYPPZZPYCCCZYZZZPY\r\n" + "ZPPCYCCPYYZYPPZCZPYCCCZZYYPZZPYPPPPZPCZC\r\n"
			+ "ZCYYZZYCPPPCCYPYYPZZZZCCCCZZCZCYCYZCZZYC\r\n" + "PYZYZZCCZZCCPPYCZPYPPZYZYYYZZPPCCZYYYZCZ\r\n"
			+ "PPPCZZPCCCCCCCCCCCCCCCCCCYCZYYYZCYYCPCPZ\r\n" + "PZYPZYPPYYYZZZPPPZPYZPYZCZZPYZCZZPPCYCCZ\r\n"
			+ "YPPYYYYCCPYPZPCPPPCZCZZYZZZZYYZPZZCCCZYY\r\n" + "YPZCZCPZYYZCCPPPYPPCCPCYZYYYCPPPYCYYCPYC\r\n"
			+ "ZPYZCCZCYZYYCPCCPPYYZPYCCPPCPZCCZCCZYYPY\r\n" + "CPPPCPZZZCYCPYCZYZZPYPZCYYCCZCZZPZYCPZCZ\r\n"
			+ "YZYCYPCPPYPPPPYYYPYPCPCPZZPPCYZCZPZZZZYP\r\n" + "ZCZPYZPPYYYPYPCZYZZYZZPZCZPPPZYCZYPCPYYC\r\n"
			+ "YPZPZYCCYPZZCCPYYCYZYYYYYCZYZZYZZPPYCZCZ\r\n" + "YCZPZCCCCCYCCCCCCCCCCCZYPYZPCZPZZPZZYPYY\r\n"
			+ "YYYYYYYYYYPYYYYYYYYYYYYYYYYYYYYYYYYYYZZP\r\n" + "ZYZCZZCCZPZCZYCPYPCCPYZYCCPPZZCZYCZCYPYP\r\n"
			+ "YYZYPZZYCPCYCZPZYCZPZCCZYCCCZZZYYYZYYPCP\r\n" + "YZZPZYPYCZCPPCZPYCCPYCYZPCCYYZYPCPPPYYPZ\r\n"
			+ "YYZPPZYCZZZYYPYCYZCCYYZPYCCYPZCCZCCCYYZC\r\n" + "CYZZPPCZYZYCCPCYYCPZPPZZPCZZYZZYZZCZYYPC\r\n"
			+ "PPZYZYZPZZZZYPZYYPZPPZPPZCYCPZYZPPYYYYYZ\r\n" + "CZZZYPZYCCYYYPPZYCYPZPCCPCYYYZZYCPYCYCYY\r\n"
			+ "YCZZCZCCYPPYYZYYYPPPZZYYCCCYYZZZYZZZYYCC\r\n" + "YCZPZPPPZPCYYYZZYCPPZYPZYCZZZZZPYYPYCYPC\r\n"
			+ "PCZZZYYZCPCPCZYYYCPYZCCPZCZPYZZPYPZPYZYY\r\n" + "ZZZZPPPPPYZCZCPYYCCCCCCCCCCCYCCCCCCPCCCP\r\n"
			+ "CPYCYZCZCZCYCPCYYCYZCZYYZCCPZZYZPZCPYCCP\r\n" + "YZZYYZZZZPZZCZCYYCZZPYZYCCPCPZYCYCZPYZPZ\r\n"
			+ "YZZZZZZZZZZZZZZZZZZZZZZZCZZZZZZZZZZZZZZZ\r\n" + "YZZPPPPPPPPPPPPPPCPPPPPYYCYCZZZCCPCCYPYZ\r\n"
			+ "YYZCPYPPYZPPYCZPYCZPCPCZZZCYCZYZCPCPZPZZ\r\n" + "CYZPCYYYYYYYYYYYYCYYYYYYYYYYYZYYCYZYPYZC\r\n"
			+ "CPZCCZZZZZZZZZZZZCZZZZZZZZZZYZCCZCPZZCCY\r\n" + "YYZPCPZZCYYYYYCPYCZPYYYPPZZCCZZCPPPPCCPP\r\n"
			+ "YYZZPCCYZCCCYPCYYPZCZZZZZPPYZCCCCCZCPPCY\r\n" + "PYYYYYYYYYYYYYYYYYYYYYYPYCZZPPYZYPPPPYCC\r\n"
			+ "YPZCZPZYPZPPCYCZYCYPCCCZCZZCCZYZYYCYYZCZ\r\n" + "CPPZZPCYYCCCYCCPZPYYZYCYZYZYPYCPPZPCPCYC\r\n"
			+ "ZPCYPYZPPCYYPYZZZPPZZZCCPYCYPCYYCYPPYCZY"; // 37
	static String input9 = "50 \r\n" + 
			"\r\n" + 
			"PZYCZPPPPPYYYYZPZCCZPZYPPPPZPYZYYCPYPPCCPYZCYPYZZY YCPCZZCYCCCCCCCCCCCCCCCCCCPCCYCCYCCCCCCCCCCCYCZYPY YYCCPPZCPCZYCYPZZCYCYYYZYYPCZYCZYZCPZCCYZPZPYZZPPY CYCZYPYZPCZYPCYCCZCCCCCCCCPCCYCCCCCCPCCCCCCCYCCYPZ CYCZYCYZZCZZZCPZPPYPZYYZZCPZYYZCZPPYZZYZYZPZYYCPCZ YYPCZCPPCYZCYCZZPPPYZYYCYPPYPYYPPZPPPPPPPPZPYPPZZY CYPPYYZZCPZZPPZPYYZYPCYZPPPPPYPPPPPPPPCZZZCCYYZPYP ZYCZZZZZCZZYZYZZPCYZYPPZPZPPCYYZPPZCPYYZYCYCYYYCZP YYPYCCYCYYZYCYYYYYYYPYYYYYPPPYCCPYYYYPYPCPPYYYYYYP PYYYYPZZZZZCZZCCCZZPZCPZPCPPCYZYYYCYCCCPYPZYYYZZPY YYCYPCCCCPZYYCYZPZYYPPPPYCPPCYPPZYCPPCYZPPCYYPPZCP ZYZYCPYZCZZYYPZPCCZYCPCPYCPZYYCCZCZZZCYCPZYYYYPPPC YYCYCCCCCPZPPYPPYCCCCCCCCCPCCYCCCCCCCCCCZYPYYPZYCZ ZYZYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYZYZZ ZYYYYZZZYZYCPCCYPYPCZZCZZYPPZYPZPZZYCCYCPYPYYYZPZP CYCYCPZPYZYZYYYCYYPYCYYZPZPZPYCPCYCYYCPYCYYYYYZZPY CYYYCZCZCPYYCCYZZZZZCYCZYZPZZYZPYCCZYCCPZCZYYCZYPC PYZYYZCZYZYPYPCZYYYYZPCZPPPZCYZCCYPPZYZZYCZYYCZPCC ZYZYCZPYZZYPCCCYZCPYYCCZCPPZZYPYCZZCYCZZCPZYYCZPPC CYZYCZZYPCYCCZYCYPZCPYCZZZPYYYYYPPPYPCPZYZZYYCZYPP ZYCYCZCYYCYZYCPYCCCZCZCZYZPPPYZCCYCPCZZZCCPYYCZCYY ZZZZZZZZZZZZZZZCZZZZZZZZZZPZZYZZZZZZZZZCPZZYYZZYPC CYZYZCPCPYYYYCZZYYCZYZCZZYPYYYYZPPPCYYZZYPCYYCZYPZ YYZYZZZPYCYYPYYCZZYCCZCZYZYPYYZYYCCCCYCZZZZYYCZPZZ ZYZYPZYZZCYYYPCYCPCYPCCZYYPCCYPZCCZZYPYZZCCYYCZCCP YYZYYZYYYYYYYYYYYYYYYYYZYYPYYYYYYYYYYYYZYYYYYCPPYC CYZYCZPZZZYCCPPZYPCZZZZZZZPZYYZZZZZPPYZZYYYYYCZCPP YYYYYYYYYYYYYYYYYYYYYYYYYYPYYYYYYYYYYYYZYYYYYCPZCC YYCYPZYCPPPPPPPPPPPPPPPPPPPPPYPPPPPPPPPZCCZYYCYZYY CYCCCZCCCCYCCCCCCCCCCCCCCCPCCYCCCCYCCCZZYCPYYCYPCY CYZYZZCCZZYCZCCCCCCCZYCZPCPCPYCYCCYPYYPZPYYYYCPPPZ CYZYYZYPYPYZPZZYZCYZZCCZZCPPYYCYZZPZYPCCZCZYYPCPPY YYZYCZYYCPYCYZZZZCYZPZCZCPPPPYZYYZZCYCZZPCPYYCZPCC CYYYPZZYCYYYCZZYYZYYPZCZYPPPZYZPZYCCCCPCZCYYYCPYCY CZCYYZPCCYYZYCZZCZPPPZCZCZPYCYPCPPYZCZZPPPPYYCZCYP ZZYYYPCZYZYYCYCCCPYCCPCZZCPYYPZZCZPYCPZPCYPYYCPYZY CYPYPPCPPPYZYZPCPZPCCCCZYZPYZYPCCZPPPPPPPPPYYCPPPP PYYYPPPZZCYYYPYZZCZYPCCZPZPYYYPCZCZZZYZYPPZYYCCCCP ZZZYCYYYZZYZCPCPZCCPYPCYPYPZYYPZPCCYPYCZZYCYYCZZPY CZZYPPPYZPYCPYYCCZYPCPCPPZPPYYZPYCZYZZCYZCYYYPPZZY YPZYCPPCZCYCCZCCYZCZYZCPPCPYYYZZYCYPZCYPPCCYYPCYYY ZPZYPPCZYCYCZYYYPCYCYYCZZPPYYYCYCCPPCYCCZCPYYPPCZY PCZPPPPPPPYPPPPPPPPPPPPPPZPYYYYPPCZYYPPCZPCYYPPYCY PCZYPCYCPZYZPCPZPZPYYZPCZZPZYYPYPCPPPYPPPCPYPPYPCY ZYPPPPYYCCYPZPZZZPPPCPPZCYZZPYCPPCZYCYCPPCYYYCPYZP PCZYYYYZZZYCZCPPPCPCZPCPYPCZYYYZPCZCYCZZZCYYYYYZZY CZCYYYYYYZYPPPYPYZYZYYYZYPPZYYZZYCZPPYZYPCPYYPYPYC ZYCZZYCYYPYZCCPPYPPCPYZCCYCZYYYZPCZZCPZPZCPYYCYPPY ZYYCPYPZCPYCPPPPYPPCZYYYCCYYYPYZCCCCPZYCYPPYPZPZYC PPYYYYYZPPZYPYYCYCZZZCYCYYYYYYYYCYYYYYYYYYYYYYYCZY";
	// 48
	static String input10 = "4\r\n" + "CYPC\r\n" + "ZZZC\r\n" + "YCYP\r\n" + "PCPC"; // 3
	static String input11 = "6\r\n" + "CCYYCC\r\n" + "YYCCYY\r\n" + "CCYYCC\r\n" + "YYCCYY\r\n" + "CCYYCC\r\n"
			+ "YYCCYY"; // 3
	static String input12 = "5\r\n" + "CPZCC\r\n" + "ZYCPZ\r\n" + "CYYPZ\r\n" + "ZPZCC\r\n" + "CCPYY";// 3

	public static void main(String[] args) {
		Scanner sc = new Scanner(input12);
		int N = sc.nextInt();

		// 맵 받기
		char[][] map = new char[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = sc.next().toCharArray();
		}

		int max = 0; // 최대로 이어지는 수

		// 사방탐색용 델타 (상우하좌)
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };

		// 첫칸 잡기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 해당 칸의 사탕 색
				char color = map[i][j];

				// 방향 잡기
				for (int k = 0; k < 4; k++) {
					// 최초좌표 설정
					int tdr = i;
					int tdc = j;

					// 현재 좌표에서 이어지는 수
					int corrCont = 1;
					boolean useOne = false;

					// 해당 방향으로 반복하여 간다
					outer : while (true) {
						tdr += dr[k];
						tdc += dc[k];

						// 인덱스확인
						if (tdr >= N || tdc >= N || tdr < 0 || tdc < 0)
							break;

						// 같은 색이면 계속
						if (color == map[tdr][tdc]) {
							corrCont++;
							continue;
						}

						// 다른 색이 나오면
						if (color != map[tdr][tdc] && !useOne) {
							// 사방탐색
							for (int k2 = 0; k2 < 4; k2++) {
								int tdr2 = tdr + dr[k2];
								int tdc2 = tdc + dc[k2];

								// 인덱스 확인
								if (tdr2 >= N || tdc2 >= N || tdr2 < 0 || tdc2 < 0)
									continue;

								// 우선적으로 진행방향과 90도 방향인 곳들 확인
								if (((k + 1) % 4 == k2 || (k + 3) % 4 == k2) && color == map[tdr2][tdc2]) {
									corrCont++;
									useOne = true;
									continue outer;
								}
							}
							if(tdr+dr[k] >= 0 && tdr+dr[k] < N && tdc+dc[k] >= 0 &&
									tdc+dc[k] < N && color == map[tdr+dr[k]][tdc+dc[k]]) {
								corrCont++;
								break outer;
							}
							break outer;
						}
						break;
					}
					max = Math.max(max, corrCont);
				}
			}
		}
		System.out.println(max);
	}

	// 50% 정답
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(input12);
//		int N = sc.nextInt();
//
//		char[][] map = new char[N][N];
//		for (int i = 0; i < N; i++) {
//			String str = sc.next();
//			map[i] = str.toCharArray();
//		}
//
//		int max = 0;
//
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) { // 첫수 잡기
//				int tmpMax = 1;
//				boolean tmp = false;
//				// 세로 보기
//				for (int i2 = i + 1; i2 < N; i2++) {
//					if (map[i][j] == map[i2][j]) {
//						tmpMax++;
//						continue;
//					}
//					if (!tmp && j + 1 > 0 && j + 1 < N && (map[i][j] == map[i2][j + 1])) {
//						tmpMax++;
//						tmp = true;
//						continue;
//					}
//					if (!tmp && j - 1 > 0 && j - 1 < N && (map[i][j] == map[i2][j - 1])) {
//						tmpMax++;
//						tmp = true;
//						continue;
//					}
//					if (!tmp && i2 + 1 > 0 && i2 + 1 < N && (map[i][j] == map[i2 + 1][j])) {
//						tmpMax++;
//						break;
//					}
//					break;
//				}
//				max = Math.max(max, tmpMax);
//				if (max == N)
//					break;
//
//				tmpMax = 1;
//				tmp = false;
//				// 가로 보기
//				for (int j2 = j + 1; j2 < N; j2++) {
//					if (map[i][j] == map[i][j2]) {
//						tmpMax++;
//						continue;
//					}
//					if (!tmp && i + 1 > 0 && i + 1 < N && (map[i][j] == map[i + 1][j2])) {
//						tmpMax++;
//						tmp = true;
//						continue;
//					}
//					if (!tmp && i - 1 > 0 && i - 1 < N && (map[i][j] == map[i - 1][j2])) {
//						tmpMax++;
//						tmp = true;
//						continue;
//					}
//					if (!tmp && j2 + 1 > 0 && j2 + 1 < N && (map[i][j] == map[i][j2 + 1])) {
//						tmpMax++;
//						break;
//					}
//					break;
//				}
//				max = Math.max(max, tmpMax);
//				if (max == N)
//					break;
//			}
//		}
//		System.out.println(max);
//	}

//7%로 틀렸다. 왜지?
//	public static void main(String[] args) {
////		Scanner sc = new Scanner(System.in);
//		Scanner sc = new Scanner(input3);
//		int N = sc.nextInt();
//
//		// 맵 받기
//		char[][] map = new char[N][N];
//		for (int i = 0; i < N; i++) {
//			map[i] = sc.next().toCharArray();
//		}
//
//		int max = 0; // 최대로 이어지는 수
//
//		// 사방탐색용 델타 (상우하좌)
//		int[] dr = { -1, 0, 1, 0 };
//		int[] dc = { 0, 1, 0, -1 };
//
//		// 첫칸 잡기
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				// 해당 칸의 사탕 색
//				char color = map[i][j];
//
//				// 방향 잡기
//				for (int k = 0; k < 4; k++) {
//					// 최초좌표 설정
//					int tdr = i;
//					int tdc = i;
//
//					// 현재 좌표에서 이어지는 수
//					int corrCont = 1;
//					boolean useOne = false;
//
//					// 해당 방향으로 반복하여 간다
//					find: while (true) {
//						tdr += dr[k];
//						tdc += dc[k];
//
//						// 인덱스확인
//						if (tdr >= N || tdc >= N || tdr < 0 || tdc < 0)
//							break;
//
//						// 다른 색이 나오면 현재까지 왔던 방향 제외한 모든 방향 확인
//						if (color != map[tdr][tdc]) {
//							for (int k2 = 0; k2 < 4; k2++) {
//
//								//다른 방향이면
//								if (k2 != (k+2)%4) {
//								
//									//인덱스 확인
//									if (tdr + dr[k2] >= N || tdc + dc[k2] >= N || tdr + dr[k2] < 0 || tdc + dc[k2] < 0)
//										break;
//
//									//주변에서 같은 색이 나왔을 때
//									if (color == map[tdr+dr[k2]][tdc+dc[k2]]) {
//										
//										// 보조축이면 continue (뒤에 더 있으면 붙여주면 되니까)
//										if((k2 == (k + 1) % 4 || k2 == (k + 3) % 4) && !useOne) {
//											useOne = true;
//											corrCont++;
//											continue;
//										} else if (k2 == (k+2)%4 && !useOne) {
//											// 같은 축에서만 같은 색 나오면 break (뒤에 더 붙일 수 없게 되니까)
//											corrCont++;
//											break find;
//										}
//									}
//								}
//							}
//						} else {
//							// 같은 색이면 corrCont 하나 추가
//							corrCont++;
//						}
//					}
//					if (corrCont == N) {
//						max = corrCont;
//						break;
//					}
//					max = Math.max(corrCont, max);
//				}
//			}
//		}
//		System.out.println(max);
//	}
}
