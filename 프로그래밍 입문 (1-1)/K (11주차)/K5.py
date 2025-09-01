
# ----- <!> -------------------------
#
# 과제 K1을 import하여 사용함
#
# ----- <!> -------------------------

import K1 as k

if (__name__ == "__main__") :
    c = ["cyan", "magenta", "yellow", "black"]

    k.init()
    k.draw_colorful_square(200, c)
    input("NAGA")