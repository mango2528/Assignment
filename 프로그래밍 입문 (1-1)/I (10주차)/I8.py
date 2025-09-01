users_exceed_1h = list()

while True :
    try :
        a = input()
    except EOFError :
        break

    if (a == '') :
        break

    '''
    print(line.split(','))
    print(line.split(',')[0])
    print(int(line.split(',')[1].strip().split(':')[0]))
    '''
    
    temp_login_time = int(a.split(',')[1].strip().split(':')[0]) * 60 + int(a.split(',')[1].strip().split(':')[1])
    temp_logout_time = int(a.split(',')[2].strip().split(':')[0]) * 60 + int(a.split(',')[2].strip().split(':')[1])

    if (temp_login_time > temp_logout_time) : # 예로, 22:30, 02:00인 상황
        temp_logout_time += 1440

    duration = temp_logout_time - temp_login_time
    duration_b60 = f"{duration // 60:02d}:{duration % 60:02d}"

    if (duration >= 60) :
        users_exceed_1h.append(f"{a.split(',')[0]} {duration_b60}")

for i in range(len(users_exceed_1h)) :
    print(users_exceed_1h[i])