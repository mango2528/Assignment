a = list(map(float, input().split()))
b = list(map(float, input().split()))

# ---- 함수 --------------------------------------------------------

def midpoint(a : list[float], b : list[float]) -> list :
    return lerp(a, b, 0.5)

# ---- 함수 --------------------------------------------------------

def lerp(a : list[float], b : list[float], t : float) -> list :
    x = (b[0] - a[0]) * t
    y = (b[1] - a[1]) * t
    return [a[0] + x, a[1] + y]

print(f'{midpoint(a, b)[0]:.2f}, {midpoint(a, b)[1]:.2f}')