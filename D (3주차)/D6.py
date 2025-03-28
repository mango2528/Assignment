a = str(input())
b = str(input())

index = b.find(' ')
length = len(b)

x = int(b[0:index])
y = int(b[index:length])

# print(str(x) + ' ' + str(y))

if a == '+' :
    print(str(x + y))
elif a == '-' :
    print(str(x - y))
elif a == '*' :
    print(str(x * y))
elif a == '/' :
    if y != 0 :
        print(str(x // y))
    else : 
        print('X')
