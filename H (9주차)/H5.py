def get_frequency(l : list) -> dict :
    l.sort()
    d = dict()

    for i in range(len(l)) :
        try :
            d.update({l[i] : d[l[i]] + 1}) # 갱신
            continue
        except :
            d.update({l[i] : 1}) # 최초 생성

    return d

a = input().split()
frequencies = get_frequency(a)

for key, value in frequencies.items() :
    print(f'{key} : {value}')