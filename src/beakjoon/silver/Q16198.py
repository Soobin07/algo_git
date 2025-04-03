import copy

N = int(input())
arr = list(map(int, input().split()))

def cul (sums, arrays):
    max_v = 0
    for i in range(1, len(arrays) - 1):
        tmp = sums + arrays[i - 1]* arrays[i + 1]
        next_arr = copy.deepcopy(arrays)
        del next_arr[i]
        
        if len(next_arr) == 2:
            max_v = max(max_v, tmp)
            continue
        max_v = max(max_v, cul(tmp, next_arr))
    
    return max_v


print(cul(0, arr))