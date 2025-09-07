# 5575 타임카드
# 24시간제. 7시간 이후 출근, 23시이전 퇴근

for i in range(3) :
    sh, sm, ss, eh, em, es = map(int, input().split())
    st = sh*60*60 + sm*60 + ss
    et = eh*60*60 + em*60 + es
    
    t = et - st
    h = t//60//60 % 24
    m = t//60 % 60
    s = t % 60
    print(h, m, s)