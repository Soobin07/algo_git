T = int(input())
for i in range(T):
    arr = [0] * 28
    text = input()
    for t in text:
        if t == ' ':
            continue
        arr[ord(t)-ord('a')] += 1
    m_idx = 0
    m_cnt = 0
    doubled = False
    for m in range(28):
        if m_cnt > arr[m]:
            continue
        elif m_cnt == arr[m]:
            doubled = True
        elif m_cnt < arr[m]:
            doubled = False
            m_cnt = arr[m]
            m_idx = m
    if doubled :
        print('?')
    else:
        print(chr(m_idx + ord('a')))
