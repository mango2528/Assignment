import turtle
import math

def init() -> None :
    turtle.setup(width=1280, height=720)
    turtle.shape("circle")
    turtle.pensize(2)
    turtle.speed(10)
    turtle.shapesize(0.5, 0.5, 2)

def draw_square(x : int, y : int, fill = False, pos = (0, 0)) -> None :
    turtle.penup()

    turtle.goto((-x / 2) + pos[0], (-y / 2) + pos[1])
    turtle.pendown()

    if (fill) :
        turtle.fillcolor("yellow")
        turtle.begin_fill()

    turtle.setheading(0)
    turtle.forward(x)

    turtle.left(90)
    turtle.forward(y)

    turtle.left(90)
    turtle.forward(x)

    turtle.left(90)
    turtle.forward(y)

    turtle.penup()
    turtle.end_fill()

def draw_octagon(s : int, pos = (0,0)) -> None :
    turtle.penup()

    turtle.goto(-s * 0.25 + pos[0], -s * 0.75 + pos[1])
    turtle.pendown()

    turtle.forward(s)

    for i in range(7) :
        turtle.left(45)
        turtle.forward(s)

    turtle.penup()

def draw_ra_triangle(x : int, y : int, pos = (0, 0)) -> None :
    turtle.penup()

    turtle.goto(-x / 2 + pos[0], -y / 2 + pos[1])
    turtle.pendown()

    turtle.forward(x)

    turtle.left(90)
    turtle.forward(y)

    turtle.goto(-x / 2 + pos[0], -y / 2 + pos[1])
    turtle.penup()

def draw_colorful_square(s : int, c : list, pos = (0, 0)) -> None :
    turtle.penup()

    turtle.goto(-s / 2 + pos[0], -s / 2 + pos[1])
    turtle.pendown()

    turtle.pencolor(c[0])
    turtle.forward(s)

    for i in range(3) :
        turtle.pencolor(c[i + 1])
        turtle.left(90)
        turtle.forward(s)

    turtle.penup()

def draw_house(body = (200, 150), roof = (300, 200), pos = (0, 0)) -> None : # 집체 (200, 150) 집지붕(300, 200)
    turtle.penup()

    turtle.goto(-body[0] / 2 + pos[0], -body[1] / 2 + pos[1])
    turtle.pendown()

    draw_square(body[0], body[1], False, pos)
    turtle.penup()

    turtle.goto(-roof[0] / 2 + pos[0], body[1] / 2 + pos[1])
    turtle.pendown()

    turtle.setheading(0)
    turtle.forward(roof[0])

    turtle.towards(pos[0], (body[1] + roof[1]) / 2 + pos[1])
    turtle.goto(pos[0], (body[1] + roof[1]) / 2 + pos[1])

    turtle.towards(-roof[0] / 2 + pos[0], body[1] / 2 + pos[1])
    turtle.goto(-roof[0] / 2 + pos[0], body[1] / 2 + pos[1])

def draw_adjacent_square(s : int, pos = (0, 0)) -> None :
    draw_square(s, s, False, (pos[0], pos[1] - s / 2))
    draw_square(s, s, False, (pos[0], pos[1] + s / 2))

def draw_example_of_aplus() -> None : # size of glyph = 150 x 150
    o = (-300, 340)

    # 6rWQ

    turtle.penup()

    turtle.goto(0 + o[0], 0 + o[1])
    turtle.pendown()

    turtle.forward(150)

    turtle.right(90)
    turtle.forward(75)
    turtle.penup()

    turtle.goto(50 + o[0], -75 + o[1])
    turtle.pendown()

    turtle.setheading(270)
    turtle.forward(75)
    turtle.penup()

    turtle.goto(100 + o[0], -75 + o[1])
    turtle.pendown()

    turtle.setheading(270)
    turtle.forward(75)
    turtle.penup()

    turtle.goto(0 + o[0], -150 + o[1])
    turtle.pendown()

    turtle.setheading(0)
    turtle.forward(150)
    turtle.penup()

    # 7IiY

    turtle.penup()

    turtle.goto(300 + o[0], 0 + o[1])
    turtle.pendown()

    turtle.setheading(225)
    turtle.forward(100)
    turtle.penup()

    turtle.goto(300 + o[0], 0 + o[1])
    turtle.pendown()

    turtle.setheading(315)
    turtle.forward(100)
    turtle.penup()

    turtle.goto(225 + o[0], -50 * math.sqrt(2) - 25 + o[1])
    turtle.pendown()

    turtle.setheading(0)
    turtle.forward(150)
    turtle.penup()

    turtle.goto(300 + o[0], -50 * math.sqrt(2) - 25 + o[1])
    turtle.pendown()

    turtle.setheading(270)
    turtle.forward(150 + (-50 * math.sqrt(2) - 25))
    turtle.penup()

    # 64uY

    turtle.penup()

    turtle.goto(450 + o[0], 0 + o[1])
    turtle.pendown()

    turtle.setheading(270)
    turtle.forward(75)
    
    turtle.setheading(0)
    turtle.forward(75)
    turtle.penup()

    turtle.goto(600 + o[0], 0 + o[1])
    turtle.pendown()

    turtle.setheading(270)
    turtle.forward(75)
    turtle.penup()

    turtle.goto(450 + o[0], -100 + o[1])
    turtle.pendown()

    turtle.setheading(270)
    turtle.forward(50)
    turtle.penup()

    turtle.goto(450 + o[0], -100 + o[1])
    turtle.pendown()

    turtle.setheading(0)
    turtle.forward(150)

    turtle.setheading(270)
    turtle.forward(50)
    turtle.penup()

    turtle.goto(450 + o[0], -150 + o[1])
    turtle.pendown()

    turtle.setheading(0)
    turtle.forward(150)
    turtle.penup()

    # 7IKs

    turtle.penup()

    turtle.goto(-200 + o[0], -225 + o[1])
    turtle.pendown()

    turtle.setheading(225)
    turtle.forward(100)
    turtle.penup()

    turtle.goto(-200 + o[0], -225 + o[1])
    turtle.pendown()

    turtle.setheading(315)
    turtle.forward(100)
    turtle.penup()

    turtle.goto(-100 + o[0], -200 + o[1])
    turtle.pendown()

    turtle.setheading(270)
    turtle.forward(150)
    turtle.penup()

    turtle.goto(-100 + o[0], -275 + o[1])
    turtle.pendown()

    turtle.setheading(0)
    turtle.forward(50)
    turtle.penup()

    # 656R

    turtle.penup()

    turtle.goto(0 + o[0], -200 + o[1])
    turtle.pendown()

    turtle.setheading(0)
    turtle.forward(75)

    turtle.setheading(270)
    turtle.forward(25)
    turtle.penup()

    turtle.goto(0 + o[0], -225 + o[1])
    turtle.pendown()

    turtle.setheading(0)
    turtle.forward(75)
    turtle.penup()

    turtle.goto(0 + o[0], -225 + o[1])
    turtle.pendown()

    turtle.setheading(270)
    turtle.forward(25)

    turtle.setheading(0)
    turtle.forward(75)
    turtle.penup()

    turtle.goto(125 + o[0], -200 + o[1])
    turtle.pendown()

    turtle.setheading(270)
    turtle.forward(50)
    turtle.penup()

    turtle.goto(125 + o[0], -225 + o[1])
    turtle.pendown()

    turtle.setheading(0)
    turtle.forward(25)
    turtle.penup()

    turtle.goto(75 + o[0], -350 + o[1])
    turtle.pendown()

    turtle.circle(40)
    turtle.penup()

    # 7ZWp

    turtle.penup()

    turtle.goto(250 + 37.5 / 4 + o[0], -200 + o[1])
    turtle.pendown()

    turtle.setheading(0)
    turtle.forward(37.5)
    turtle.penup()

    turtle.goto(237.5 + o[0], -225 + o[1])
    turtle.pendown()

    turtle.setheading(0)
    turtle.forward(75)
    turtle.penup()

    turtle.goto(275 + o[0], -290 + o[1])
    turtle.pendown()

    turtle.circle(25)
    turtle.penup()

    turtle.goto(350 + o[0], -200 + o[1])
    turtle.pendown()

    turtle.setheading(270)
    turtle.forward(75)
    turtle.penup()

    turtle.goto(350 + o[0], -237.5 + o[1])
    turtle.pendown()

    turtle.setheading(0)
    turtle.forward(25)
    turtle.penup()

    turtle.goto(250 + o[0], -300 + o[1])
    turtle.pendown()

    turtle.setheading(270)
    turtle.forward(50)
    turtle.penup()

    turtle.goto(350 + o[0], -300 + o[1])
    turtle.pendown()

    turtle.setheading(270)
    turtle.forward(50)
    turtle.penup()

    turtle.goto(250 + o[0], -325 + o[1])
    turtle.pendown()

    turtle.setheading(0)
    turtle.forward(100)
    turtle.penup()

    turtle.goto(250 + o[0], -350 + o[1])
    turtle.pendown()

    turtle.setheading(0)
    turtle.forward(100)
    turtle.penup()

    # 64uI

    turtle.penup()

    turtle.goto(450 + o[0], -225 + o[1])
    turtle.pendown()

    turtle.setheading(270)
    turtle.forward(75)
    
    turtle.setheading(0)
    turtle.forward(75)
    turtle.penup()

    turtle.goto(600 + o[0], -200 + o[1])
    turtle.pendown()

    turtle.setheading(270)
    turtle.forward(150)
    turtle.penup()

    # 64uk

    turtle.penup()

    turtle.goto(675 + o[0], -225 + o[1])
    turtle.pendown()

    turtle.setheading(0)
    turtle.forward(75)

    turtle.goto(675 + o[0], -225 + o[1])
    turtle.pendown()

    turtle.setheading(270)
    turtle.forward(75)
    
    turtle.setheading(0)
    turtle.forward(75)
    turtle.penup()

    turtle.goto(800 + o[0], -200 + o[1])
    turtle.pendown()

    turtle.setheading(270)
    turtle.forward(150)
    turtle.penup()

    turtle.goto(800 + o[0], -275 + o[1])
    turtle.pendown()

    turtle.setheading(0)
    turtle.forward(50)
    turtle.penup()

    # 4pmh

    turtle.penup()
    turtle.color("red")

    turtle.goto(300 + o[0], -650 + o[1])
    turtle.pendown()

    turtle.left(140)
    turtle.forward(113)

    turtle.tracer(0)

    for i in range(200) :
        turtle.right(1)
        turtle.forward(1)

    turtle.left(120)

    for i in range(200) :
        turtle.right(1)
        turtle.forward(1)

    turtle.forward(112)

    turtle.update()

    # 진짜 광기

if (__name__ == "__main__") :
    init()
    draw_square(300, 150, fill=True)
    input("NAGA")