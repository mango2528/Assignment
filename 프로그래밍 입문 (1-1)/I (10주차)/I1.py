l = list()

while True :
    try :
        a = input()
    except EOFError :
        break

    if (a == '') :
        break

    l.append(float(a))

l.sort(reverse=True)

for i in range(3) :
    print(l[i], end=' ')
