def get_miles(x : float) -> float :
    return x * 0.000621371

def get_yards(x : float) -> float :
    return x * 1.09361

def get_feet(x : float) -> float :
    return x * 3.28084

def get_inches(x : float) -> float :
    return x * 39.3701

values = []

while (True) :
    a = float(input())

    if (a < 0) :
        break

    values.append(a)

for i in values :
    print(f"{i:.2f} meters: \n --> {get_miles(i):.4f} miles, {get_yards(i):.2f} yards, {get_feet(i):.2f} feet, {get_inches(i):.0f} inches.")