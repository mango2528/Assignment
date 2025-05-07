def sum_all(t : tuple) -> int :
    sum = 0

    for i in range(len(t)) :
        sum += t[i]

    return sum

a = tuple(map(int, input().split()))

print(sum_all(a))