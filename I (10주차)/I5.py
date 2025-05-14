a = list()
b = list()

while True :
    try :
        a = input().lower()
    except EOFError :
        break

    if (a == '') :
        break
    
    a = ''.join(c if c.isalpha() else ' ' for c in a)
    a = a.split()

    for i in range(len(a)) :
        b.append(a[i])

# print(b)

b = list(set(b)) # 집합은 중복이 없다!
b.sort()

for i in range(len(b)) :
    if (not b[i] == '') :
        print(b[i])