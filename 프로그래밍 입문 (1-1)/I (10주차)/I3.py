employees = dict()

while True :
    try :
        a = input().split()
    except EOFError :
        break    

    if (a == []) :
        break

    sum = 0

    for i in range(len(a) - 1) :
        sum += int(a[i + 1])

    employees.update({a[0] : sum})

sorted_employees = sorted(employees.items(), key=lambda x : x[1], reverse=True)[:3]

for i in range(len(sorted_employees)) :
    print(f'{sorted_employees[i][0]} {sorted_employees[i][1]}')