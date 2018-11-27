package main.strategy;

import main.interfaces.IMoveStrategy;

public class MoveCircle implements IMoveStrategy {
    int x,y,dir;

    public MoveCircle(int x, int y) {
        this.x = x;
        this.y = y;
        this.dir = 3;
    }

    @Override
    public void move() {

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
