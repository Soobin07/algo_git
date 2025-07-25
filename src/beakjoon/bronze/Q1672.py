before = {'A':{'A':'A', 'G':'C', 'C':'A', 'T':'G'}, 
          'G':{'A':'C', 'G':'G', 'C':'T', 'T':'A'}, 
          'C':{'A':'A', 'G':'T', 'C':'C', 'T':'G'}, 
          'T':{'A':'G', 'G':'A', 'C':'G', 'T':'T'}}

N = int(input())
str_ = input()
list_ = [str_[N-1]]
for i in range(1, N):
    list_ = [before[str_[N-i-1]][list_[0]]]

print(list_[0])
