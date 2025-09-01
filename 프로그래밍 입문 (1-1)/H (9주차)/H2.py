def get_contain(l1 : list, l2 : list) -> list :
    result = list()
    sub = list()
    obj = list()

    if (len(l1) > len(l2)) :
        sub = l1
        obj = l2
    else :
        sub = l2
        obj = l1

    for i in range(len(sub)) :
        if (sub[i] in obj and not sub[i] in result) :
            result.append(sub[i])

    return sorted(result, reverse=True)

a = list(map(int, input().split()))
b = list(map(int, input().split()))

contains = get_contain(a, b)

# print(contains)

for i in range(len(contains)) :
    print(contains[i] , end=' ')

if (contains == []) :
    print('X')

# 15 9 10 56 23 78 5 4 9 
# 9 4 5 36 47 26 10 45 87