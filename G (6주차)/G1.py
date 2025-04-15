a = list(map(int, input().split()))
_sum = int()
context = str()

for i in range(len(a)) :
    _sum += a[i]
    print(_sum, end=' ')