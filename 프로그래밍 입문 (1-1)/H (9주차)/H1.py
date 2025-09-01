def get_count(t : tuple, num : int) -> int :
    count = 0

    for i in range(len(t)) :
        if (t[i] == num) :
            count += 1

    return count

x = int(input())
a = tuple(map(int, input().split()))

print(get_count(a, x))