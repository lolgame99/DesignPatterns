package main.strategy;

import main.interfaces.IMoveStrategy;

public class MoveCircle implements IMoveStrategy {
    int x,y, distance, startX, startY;

    public MoveCircle(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
        this.startX = x;
        this.startY = y;
    }

    @Override
    public void move() {
        if (this.y > this.startY+this.distance){
            this.x++;
        } else if (this.x > this.startY+this.distance){
            this.y--;
        } else if (this.y < this. startY){
            this.x--;
        } else {
            this.y++;
        }
    }

    @Override
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
