class Student :
    def __init__(self, name, kor, eng, mat) :
        self.name = name
        self.kor = kor
        self.eng = eng
        self.mat = mat
N = int(input())
arr = []
for i in range(N) :
    str_ = input().split()
    arr.append(Student(str_[0], int(str_[1]), int(str_[2]), int(str_[3])))

ans = sorted(arr, key = lambda x : (-x.kor, x.eng, -x.mat, x.name))
for a in ans :
    print(a.name)