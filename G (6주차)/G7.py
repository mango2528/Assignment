a = int(input())
i_list = list(map(int, input().split()))

def get_exceed_elements(k : float) -> int :
    exceed_count = int()

    for i in range(len(i_list)) :

        if (k < i_list[i]) :
            exceed_count += 1

    return exceed_count

print(get_exceed_elements(a))