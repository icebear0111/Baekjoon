n = int(input())
students = []
for _ in range (n):
    name, day, month, year = input().split()
    day, month, year = map(int, (day, month, year))
    students.append((year, month, day, name))
students.sort()
print(students[-1][3])
print(students[0][3])