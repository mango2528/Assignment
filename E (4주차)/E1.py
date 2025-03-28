n = int(input())
sum = int()
avg = int()

for i in range(n) :
    num = int(input())
    sum += num

avg = sum / n

print(f'Sum = {sum}, Average = {avg:.2f}')