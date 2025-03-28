n = int(input())

sam = int()
o = int()
sibo = int()

for i in range(1, n + 1) :

    if (i % 3 == 0) :
        sam += 1
    
    if (i % 5 == 0) :
        o += 1

    if (i % 15 == 0) :
        sibo += 1

print(f'{sam} {o} {sibo}')
