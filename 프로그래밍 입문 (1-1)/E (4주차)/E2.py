a = str()
sum = int()
avg = float()
att = int()

while (True) :
    a = input()

    if (a == 'Q') :
        break
    
    att += 1
    sum += int(a)

if (att == 0) :
    print('Sum = 0, Average = 0.00')
    exit()

avg = sum / att

print(f'Sum = {sum}, Average = {avg:.2f}')