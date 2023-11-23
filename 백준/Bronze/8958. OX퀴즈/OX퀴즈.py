numberOfTestCase = int(input())

for i in range (numberOfTestCase):
    testCase = input()
    score_sum = 0
    score = 0

    for ox in testCase:
        if ox == 'O':
            score += 1
            score_sum += score
        else:
            score = 0
            
    print(score_sum)