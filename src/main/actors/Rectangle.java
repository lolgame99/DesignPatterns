package main.actors;

import main.interfaces.IMoveStrategy;
import main.interfaces.Observer;
import main.strategy.MoveLeft;
import org.newdawn.slick.Graphics;

public class Rectangle extends AbstractIActor implements Observer {
    private int width, height;

    public Rectangle(IMoveStrategy MoveStrategy, int width, int height) {
        super(MoveStrategy);
        this.width = width;
        this.height = height;
    }

    @Override
    public void move() {
        IMoveStrategy.move();
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawRect(IMoveStrategy.getX(), IMoveStrategy.getY(), this.width, this.height);
    }

    @Override
    public void setIMoveStrategy(IMoveStrategy moveStrategy) {
        this.IMoveStrategy = moveStrategy;
    }

    @Override
    public IMoveStrategy getIMoveStrategy() {
        return IMoveStrategy;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public void inform() {
        this.setIMoveStrategy(new MoveLeft(this.IMoveStrategy.getX(), this.IMoveStrategy.getY()));
    }
}
