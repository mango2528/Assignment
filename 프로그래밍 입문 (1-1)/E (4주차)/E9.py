n = int(input())

if (n < 2) :
    print('NO')
    exit()

for i in range(2, n) :
    if (n % i == 0) :
        print('NO')
        exit()

print('YES')