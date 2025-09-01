def get_sum(d : dict) -> int :
    sum = 0

    for value in d.values() :
        sum += int(value)

    return sum

a = input().split()
dic = dict()

for i in range(0, len(a), 2) :
    dic.update({a[i] : a[i + 1]})

# print(dic)

print(get_sum(dic))