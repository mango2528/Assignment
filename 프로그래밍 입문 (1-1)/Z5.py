def pass_time() -> None :
    for i in range(len(passings)) :
        passings[i][1] += 1

        if (passings[i][1] >= w) :
            global total_weight
            total_weight -= passings[i][1]
            del passings[i]

        global elipsed
        elipsed += 1

a = input().split()

n = int(a[0]) # 트럭의 수
w = int(a[1]) # 다리의 길이
l = int(a[2]) # 최대 하중

weights = list(map(int, input().split())) # 트럭 무게들
elipsed = 0 # 시간 경과

# 4 2 10
# 7 4 5 6
# passings = [[0, 1], [1, 1]]

passed_index = 0
passings = []
total_weight = 0

while (len(weights) > 0) :
    if (weights[0] > l) :
        print('X') # 모찌나간다
        exit()

    for i in range(len(weights)) :
        print("First")
        
        if (i < passed_index) :
            pass_time()
            continue
        
        for j in range(len(passings)) :
            total_weight += passings[j][1]
    
        if (passings == [] or (total_weight + weights[i] <= l)) :
            passings.append([i, 1])
            passed_index += 1
            print(passings[i])
            pass_time()
            break
        else :
            pass_time()
            break

print(elipsed)

    
    
