a = input()
context = a.split()[0]
key = a.split()[1]
indexs = list()

for i in range(len(context)) :

    if (context[i] == key) :
        indexs.append(i)

print(indexs)
