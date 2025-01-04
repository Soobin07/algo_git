from itertools import permutations

n = int(input())
k = int(input())

arr = list()
for _ in range(n):
    arr.append(input())

visited = set()

for perm in permutations(arr, k):
    visited.add(''.join(perm))

print(len(visited))