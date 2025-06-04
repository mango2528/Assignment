def pass_time() -> None :
    global elipsed
    global passed_index

    for i in range(len(passings)) :
        passings[i][1] += 1

        if (passings[i][1] > w) :
            del passings[i]

            temp_weight = 0
            
            for j in range(len(passings)) :
                temp_weight += weights[passings[j][0]]

            if (passed_index == len(weights)) :
                elipsed += 1
                END_THIS()
                return
            
            if (passings == [] or (temp_weight + weights[passed_index] <= l)) :
                pass_truck(passed_index)
                pass_time()

            return

    elipsed += 1

    # print(f"{passings}, {elipsed}")

def pass_truck(i : int) -> None :
    global passed_index
    passings.append([i, 0])
    passed_index += 1

def END_THIS() -> None :
    global elipsed

    while (passings != []) :
        for i in range(len(passings)) :
            passings[i][1] += 1

            if (passings[i][1] > w) :
                del passings[i]
                elipsed += 1
                break
    
    # print(f"ended : {elipsed}")
    print(elipsed)
    exit()

a = input().split()

n = int(a[0]) # 트럭의 수
w = int(a[1]) # 다리의 길이
l = int(a[2]) # 최대 하중

# weights = list(map(int, input().split())) # 트럭 무게들
weights = []
for i in range(1000) :
    weights.append(10)
elipsed = 0 # 시간 경과

passed_index = 0
passings = []

# 4 2 10
# 7 4 5 6
# passings = [[0, 1], [1, 1]]

while (True) :
    if (weights != [] and len(weights) > passed_index and weights[passed_index] > l) :
        print(f"{weights[passed_index]} : 모찌나간다")
        exit()

    total_weight = 0

    for i in range(len(weights) + 1) :
        if (i < passed_index) :
            continue
        
        for j in range(len(passings)) :
            total_weight += weights[passings[j][0]]

        # print(passed_index)

        if (passed_index == len(weights)) :
            pass_time()
            break
    
        if (passings == [] or (total_weight + weights[i] <= l)) :
            pass_truck(i)
            pass_time()
            break
        else :
            pass_time()
            break