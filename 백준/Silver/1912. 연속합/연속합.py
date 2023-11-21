n = int(input())
seq = list(map(int, input().split()))

for i in range (1, n):
    seq[i] = max(seq[i], seq[i] + seq[i - 1])

print(max(seq))