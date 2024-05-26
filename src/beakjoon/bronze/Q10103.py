n = int(input())
cy_score = 100
sd_score = 100
for i in range(0, n) :
    scores = input().split(" ")
    if scores[0] > scores[1] :
        sd_score -= int(scores[0])
    elif scores[0] < scores[1] :
        cy_score -= int(scores[1])
 
print(cy_score)
print(sd_score)
