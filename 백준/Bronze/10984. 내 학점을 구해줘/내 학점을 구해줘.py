T = int(input())
for i in range (T):
    N = int(input())
    sumOfCredit = 0
    sumOfGrade = 0
    for j in range (N):
        C, G = map(float, input().split())
        sumOfCredit += C
        sumOfGrade += C * G
    print("%d %.1f" % (sumOfCredit, sumOfGrade / sumOfCredit))