import math

char = str(input())

x = [0, 0, 0]
y = [0, 0, 0]

index_x = 0
index_y = 0

index_x = char.find(' ', 0)
x[0] = int(char[0 : index_x])
index_y = char.find(' ', index_x + 1)
y[0] = int(char[index_x + 1 : index_y])

index_x = char.find(' ', index_y + 1)
x[1] = int(char[index_y + 1 : index_x])
index_y = char.find(' ', index_x + 1)
y[1] = int(char[index_x + 1 : index_y])

index_x = char.find(' ', index_y + 1)
x[2] = int(char[index_y + 1 : index_x])
index_y = len(char)
y[2] = int(char[index_x + 1 : index_y])

'''
for i in range(0,3) :
    print(str(x[i]) + 'x ' + str(y[i] + 'y'))
'''

a = math.sqrt(((x[0] - x[1]) ** 2) + ((y[0] - y[1]) ** 2))
b = math.sqrt(((x[1] - x[2]) ** 2) + ((y[1] - y[2]) ** 2))
c = math.sqrt(((x[2] - x[0]) ** 2) + ((y[2] - y[0]) ** 2))
s = (a + b + c) / 2
area = math.sqrt(s * (s - a) * (s - b) * (s - c))

# print(str(a) + ' ' + str(b) + ' ' + str(c))

print('Area = ' + f'{area:.2f}')

# 이거 진짜에요...?