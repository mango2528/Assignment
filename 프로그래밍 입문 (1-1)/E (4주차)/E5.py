amount = int(input())
interest = float(input())
span = int(input())

for i in range(span) :
    amount *= 1 + (interest / 100)

print(f'{amount:.0f}')