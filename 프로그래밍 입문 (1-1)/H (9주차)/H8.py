def get_twice(l : list) -> set :
    l.sort()
    d = dict() # 딕셔너리일 이유가 없는 것 같다...
    b = list()

    for i in range(len(l)) :
        if not (l[i] in b) :
            b.append(l[i])

    for i in range(len(l)) :

        try :
            d.update({l[i] : d[l[i]] + 1}) # 갱신
            continue
        except :
            d.update({l[i] : 1}) # 최초 생성

    keys = []

    for i in range(len(d)) :
        if (d[b[i]] >= 2) :
            keys.append(b[i])
    
    return keys

a = list(map(int, input().split()))
twice = get_twice(a)

if (twice != []) :
    result = ""

    for i in range(len(twice)) :
        result += f'{twice[i]} '

    print(result)
else :
    print(None)