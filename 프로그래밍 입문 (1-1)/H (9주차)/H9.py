def get_mode(l : list) -> list :
    l.sort()
    d = dict()
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

    check_valid = d[b[0]]

    for i in range(len(b) - 1) : # 최빈값 존재 유무 확인

        if (check_valid != d[b[i + 1]]) : #최빈값がある

            keys = []
            most = 0

            for i in range(len(b)) :

                if (d[b[i]] > most) :
                    keys.clear()
                    keys.append(b[i])
                    most = d[b[i]]
                    continue

                if (d[b[i]] == most) :
                    keys.append(b[i])
                    most = d[b[i]]
                    continue

            return keys
        
    return None # 최빈값がなし

a = list(map(int, input().split()))

# print(a)

mode = get_mode(a)

try :
    result = ""

    for i in range(len(mode)) :
        result += f'{mode[i]} '

    print(result)
except :
    print(mode)