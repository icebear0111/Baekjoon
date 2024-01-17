n = int(input())
for i in range (n):
    p = int(input())
    maxPrice = 0
    nameOfMaxPrice = ""
    for i in range (p):
        C, name = input().split()
        if int(C) > maxPrice:
            maxPrice = int(C)
            nameOfMaxPrice = name
    print(nameOfMaxPrice)