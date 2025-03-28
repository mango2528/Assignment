import math

char = str(input())

index1 = char.find(' ', 0)
index2 = char.find(' ', index1 + 1)

a = float(char[0:index1])
b = float(char[index1:index2])
c = float(char[index2:len(char)])

# print(str(a) + ' ' + str(b) + ' ' + str(c))

x = 0
x1 = 0
x2 = 0

D = (b ** 2) - (4 * a * c)

if D > 0 :
    x1 = (-b + math.sqrt(D)) / (2 * a)
    x2 = (-b - math.sqrt(D)) / (2 * a)
    print('x1 = ' + str(round(x1, 1)) + ', x2 = ' + str(round(x2, 1)))
elif D == 0 : 
    x = -b / (2 * a)
    print('x = ' + str(round(x, 1)))    
elif D < 0 :
    print('Imaginary root')