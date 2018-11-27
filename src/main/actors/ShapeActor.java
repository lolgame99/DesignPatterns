package main.actors;

import main.interfaces.IMoveStrategy;
import org.newdawn.slick.Graphics;

import java.util.Random;

public class ShapeActor extends AbstractIActor {
    private int width, height;
    private int shapeNumber;

    public ShapeActor(IMoveStrategy IMoveStrategy, int width, int height) {
        super(IMoveStrategy);
        this.width = width;
        this.height = height;
        this.shapeNumber = generateRandomShape();
    }

    public static int generateRandomShape(){
        Random random = new Random();
        int randomNum = random.nextInt(2);

        return randomNum;
    }

    @Override
    public void move() {
        this.IMoveStrategy.move();
    }

    @Override
    public void render(Graphics G) {
        switch (shapeNumber){
            case 0:
                G.drawOval(this.IMoveStrategy.getX(), this.IMoveStrategy.getY(), this.width, this.height);
                break;

            case 1:
                G.drawRect(this.IMoveStrategy.getX(), this.IMoveStrategy.getY(), this.width, this.height);
                break;
        }
    }

    @Override
    public void setIMoveStrategy(IMoveStrategy moveStrategy) {
        this.IMoveStrategy = moveStrategy;
    }

    @Override
    public IMoveStrategy getIMoveStrategy() {
        return this.IMoveStrategy;
    }
}
