N = int(input())

for i in range (1, N + 1):
    for k in range (0, i - 1):
        print(" ", end="")
    for j in range (1, N - i + 2):
        print("*", end="")
    print()