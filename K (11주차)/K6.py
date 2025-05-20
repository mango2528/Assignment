
# ----- <!> -------------------------
#
# 과제 K1을 import하여 사용함
#
# ----- <!> -------------------------

import K1 as k

if (__name__ == "__main__") :
    k.init()

    for y in range(2) :
        for x in range(3) :
            k.draw_house(pos=(((1280 / 3) * x) - 1280 / 3, ((720 / 2) * y) - 720 / 3))

    input("NAGA")