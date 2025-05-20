import turtle

def steps(t : turtle, w : int, h : int, n : int) -> None :
    t.penup()

    t.goto(-w * n / 2, -h * n / 2)
    t.pendown()

    for i in range(n) :
        t.left(90)
        t.forward(h)
        t.right(90)
        t.forward(w)

    t.penup()

turtle.setup(width=1280, height=720)
turtle.shape("circle")
turtle.pensize(2)
turtle.speed(10)
turtle.shapesize(0.5, 0.5, 2)

steps(turtle, 50, 20, 10)

input("NAGA")
