package com.javarush.task.task24.task2413;

public class Ball extends BaseObject{
    private double speed;
    private double direction;
    private double dx;
    private double dy;
    private boolean isFrozen;



    public Ball(double x, double y, double speed, double direction) {
        super(x, y, 1);
        isFrozen = true;
        this.speed = speed;
        this.direction = direction;
    }

    public void setDirection(double direction) {
        this.direction = direction;
        double angle = Math.toRadians(direction);
        dx = Math.cos(angle) * speed;
        dy = -Math.sin(angle) * speed;
    }
    void checkRebound(int minx, int maxx, int miny, int maxy){

    }

    @Override
    void draw(Canvas canvas) {
        canvas.setPoint(x, y, 'O');

    }

    @Override
    void move() {
        if(!isFrozen) {
            x = x + dx;
            y = y + dy;
        }

    }
    void start(){
        isFrozen = false;
    }

    public double getSpeed() {
        return speed;
    }

    public double getDirection() {
        return direction;
    }

    public double getDx() {
        return dx;
    }

    public double getDy() {
        return dy;
    }
}
