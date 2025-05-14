
# !-- 출력 파일의 위치와 이름은 Desktop\의 grades.txt 임 --!

l = list()
max = 0
min = 0

while True :
    try :
        a = int(input())
    except EOFError :
        break

    if (a == 0) :
        break

    l.append(a)

    if (min == 0 or min > a) :
        min = a
    elif (max == 0 or max < a) :
        max = a

avg = sum(l) / len(l)

file_name = r"Desktop\grades.txt"
f = open(file_name, 'w')

for i in range(len(l)) :
    f.write(f"{l[i]}\n")

print(f"{avg:.1f} {max} {min}")

f.close()