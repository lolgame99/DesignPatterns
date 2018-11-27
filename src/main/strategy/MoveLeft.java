package main.strategy;

import main.interfaces.IMoveStrategy;

public class MoveLeft implements IMoveStrategy {
    int x,y;

    public MoveLeft(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void move() {
        this.x--;
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
