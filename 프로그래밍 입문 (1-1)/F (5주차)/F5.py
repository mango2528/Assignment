from typing import List

n = int(input())

inflation_rates : List[float] = list()

# ---- 함수 ------------------------------------------------------------------

def get_inflation_rate(i : float, f : float) -> float :
    return ((f - i) / i) * 100

def get_average_inflation_rate() -> float :
    for i in range(n) :
        a = input()
        init = float(a.split()[0])
        final = float(a.split()[1])

        inflation_rates.append(get_inflation_rate(init, final))

    # print(inflation_rates)

    return sum(inflation_rates) / n

# ---- 함수 ------------------------------------------------------------------

print(f'Average Inflation Rate: {get_average_inflation_rate():.2f}%')

# 33500.0 34000.0
# 34000.0 34250.0
# 34250.0 34380.0