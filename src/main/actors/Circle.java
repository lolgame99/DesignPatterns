package main.actors;

import main.interfaces.IMoveStrategy;
import main.interfaces.Observer;
import main.strategy.MoveDown;
import org.newdawn.slick.Graphics;

public class Circle extends AbstractIActor implements Observer {

    private int radius;

    public Circle(IMoveStrategy IMoveStrategy, int radius) {
        super(IMoveStrategy);
        this.radius = radius;
    }

    @Override
    public void move() {
        IMoveStrategy.move();
        //System.out.println("X:" + IMoveStrategy.getX() + " --- Y:" + IMoveStrategy.getY());
    }

    @Override
    public void render(Graphics G) {
        G.drawOval(IMoveStrategy.getX(), IMoveStrategy.getY(),radius,radius);
    }

    @Override
    public void setIMoveStrategy(IMoveStrategy moveStrategy) {
        this.IMoveStrategy = moveStrategy;
    }

    @Override
    public IMoveStrategy getIMoveStrategy() {
        return this.IMoveStrategy;
    }

    @Override
    public void inform() {
        this.setIMoveStrategy(new MoveDown(this.IMoveStrategy.getX(), this.IMoveStrategy.getY()));
    }
}
