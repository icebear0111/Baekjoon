S = input()
index = [-1] * 26

for i in range (len(S)):
    alphabet = ord(S[i]) - ord('a')
    if (index[alphabet] == -1):
        index[alphabet] = i

for j in range (len(index)):
    print(index[j], end=' ')