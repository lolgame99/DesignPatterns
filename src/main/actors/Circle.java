package main.actors;

import main.interfaces.IMoveStrategy;
import org.newdawn.slick.Graphics;

public class Circle extends AbstractIActor {

    private int radius;

    public Circle(IMoveStrategy IMoveStrategy) {
        super(IMoveStrategy);
    }

    @Override
    public void move() {
        IMoveStrategy.move();
        System.out.println("X:" + IMoveStrategy.getX() + " --- Y:" + IMoveStrategy.getY());
    }

    @Override
    public void render(Graphics G) {
        G.drawOval(IMoveStrategy.getX(), IMoveStrategy.getY(),50,50);
    }
}
