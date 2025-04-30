a = list(map(int, input().split()))
a.sort()
b = list()

# print(a)

for i in range(len(a)) :
    if not (a[i] in b) :
        b.append(a[i])

print(b)
exit()

def mode(l : list) -> dict :
    d = dict()

    for i in range(len(a)) :
        try :
            d.update({l[i] : d[l[i]] + 1})
            continue
        except :
            d.update({l[i] : 1})

    return d

print(mode(a))
