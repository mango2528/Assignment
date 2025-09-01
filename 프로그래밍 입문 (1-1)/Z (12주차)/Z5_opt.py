import collections

n, w, l = map(int, input().split()) # n트럭의 수, w다리 길이, l최대 하중
# print(f"{n}, {w}, {l}")

weights = list(map(int, input().split()))
'''
weights = []
for i in range(1000) :
    weights.append(10)
'''

elapsed = 0 # 시간 경과
current_weight = 0 # 현재 하중

bridge = collections.deque([0] * w)
# bridge = collections.deque([1, 2, 3, 4, 5, 6, 7, 8, 9, 10])
# print(bridge)

# bridge.popleft()
# print(bridge)

# 4 2 10
# 7 4 5 6

i = 0

while i < n :
    elapsed += 1

    out = bridge.popleft() # <- [] <-, 리턴은 다리에서 나간 무게
    current_weight -= out

    if (weights[i] + current_weight <= l) :
        bridge.append(weights[i])
        current_weight += weights[i]
        i += 1
    else :
        bridge.append(0)

    # print(list(bridge))

elapsed += w # 마지막 트럭이 지나갈 때 까지 걸리는 시간은 다리 길이임 ([6, 0] -> [0 , 0])
print(elapsed)



''' 쓰레기 코드 (O(n^2))

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
            
'''