a = int(input())

if not (a >= 1 and a <= 100) :
    exit()

for i in range(1, a + 1) :
    print('$' * i)