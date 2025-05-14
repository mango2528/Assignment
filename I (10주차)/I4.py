a = str()
l = list()

while True :
    try :
        a = input().lower()
    except EOFError :
        break

    if (a == '') :
        break

    l.append(a)

for i in range(len(l)) :
    b = ''.join(c for c in l[i] if str(c).isalnum() or str(c) == ' ')
    print(b)