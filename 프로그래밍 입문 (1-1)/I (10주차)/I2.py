names_passed = list()

while True :
    try :
        a = input().split()
    except EOFError :
        break

    if (a == []) :
        break

    sum = 0
    avg = 0

    for i in range(3) :
        sum += int(a[i + 1])

    avg = sum / 3

    if (avg >= 60) :
        names_passed.append(a[0])

names_passed.sort()
print(len(names_passed))

for i in range(len(names_passed)) :
    print(names_passed[i])