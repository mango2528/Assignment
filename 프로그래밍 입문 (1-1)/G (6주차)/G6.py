from collections import Counter
from typing import List

a : List[str] = sorted(input(), reverse=True)

def get_most_element(list : list[str]) -> str :
    return f'{Counter(list).most_common(1)[0][0]} {Counter(list).most_common(1)[0][1]}'

print(get_most_element(a))