import sys

N = int(sys.stdin.readline())
list_ = list()
for i in range(N):
    list_.append(int(sys.stdin.readline()))

list_.sort()
sys.stdout.write('\n'.join(map(str, list_)) + '\n')
