def get_divisor_number(x : int) -> int :
    num = 0

    for i in range(x) :
        if (i == 0 or i == 1 or i == x - 1) :
            continue

        if (x % (i) == 0) :
            num += 1

    return num

a = input().split()
n = int(a[0])
k = int(a[1])

if (get_divisor_number(n) == k) :
    print("Yes")
else :
    print("No")

