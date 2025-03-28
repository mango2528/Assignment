a = int(input())
b = int()
c = str()
d = int()

for i in range(a) :
    b += 1
    c = ''

    for j in range(1, b + 1) :
        c += f'{d + j} '
    
    d += b

    print(c)