import math

a = input().split()

price = int(a[0])
sale = float(a[1])
day = int(a[2])

curprice = float(price);
curday = 1

# print(f'{price}, {sale}. {day}')

curprice = round(curprice)

for i in range(day) :
    print(f'{curday} {round(curprice)} won')
    curprice = curprice * ((100 - sale) / 100)
    curday += 1
