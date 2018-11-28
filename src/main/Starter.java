package main;

import main.actors.Circle;
import main.actors.Rectangle;
import main.actors.ShapeActor;
import main.actors.SingletonScore;
import main.interfaces.IActor;
import main.interfaces.IMoveStrategy;
import main.interfaces.Observer;
import main.strategy.*;
import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.Random;

public class Starter extends BasicGame {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private Circle circle;
    private Rectangle rec;
    private IMoveStrategy ms;
    private ArrayList<IActor> actors = new ArrayList<>();
    private ArrayList<Observer> observers = new ArrayList<>();

    public Starter() {
        super("Patterns");
    }

    @Override
    public void init(GameContainer gc) throws SlickException {
        Random randomGen = new Random();
        this.circle = new Circle(new MoveDown(100,100),30);
        this.rec = new Rectangle(new MoveRight(30,30),30,30);
        actors.add(this.rec);
        actors.add(this.circle);
        observers.add(this.rec);
        observers.add(this.circle);

        for (int i = 0; i < 4; i++) {
            actors.add(new ShapeActor(new MoveRight(randomGen.nextInt(300),randomGen.nextInt(300)), randomGen.nextInt(100), randomGen.nextInt(100)));
        }

    }

    @Override
    public void update(GameContainer gc, int d) throws SlickException {
        for (IActor actor:
                this.actors) {
            actor.move();
        }

        if (this.circle.getIMoveStrategy().getY() > HEIGHT) {
            this.circle.setIMoveStrategy(new MoveUp(this.circle.getIMoveStrategy().getX(),this.circle.getIMoveStrategy().getY()));
        } else if (this.circle.getIMoveStrategy().getY() < 0 ){
            this.circle.setIMoveStrategy(new MoveDown(this.circle.getIMoveStrategy().getX(), this.circle.getIMoveStrategy().getY()));
        }

        if (this.rec.getIMoveStrategy().getX() > WIDTH-100) {
            this.rec.setIMoveStrategy(new MoveDown(this.rec.getIMoveStrategy().getX(), this.rec.getIMoveStrategy().getY()));
            this.rec.getIMoveStrategy().setX(700);
            SingletonScore.getInstance().incrementScore();
            System.out.println(SingletonScore.getInstance().getScore());

        } else if (this.rec.getIMoveStrategy().getY() > HEIGHT-100) {
            this.rec.setIMoveStrategy(new MoveLeft(this.rec.getIMoveStrategy().getX(), this.rec.getIMoveStrategy().getY()));
            this.rec.getIMoveStrategy().setY(500);
        } else if (this.rec.getIMoveStrategy().getX() < 50) {
            this.rec.setIMoveStrategy(new MoveUp(this.rec.getIMoveStrategy().getX(), this.rec.getIMoveStrategy().getY()));
            this.rec.getIMoveStrategy().setX(50);
        } else if (this.rec.getIMoveStrategy().getY() < 50) {
            this.rec.setIMoveStrategy(new MoveRight(this.rec.getIMoveStrategy().getX(), this.rec.getIMoveStrategy().getY()));
            this.rec.getIMoveStrategy().setY(50);
        }
    }

    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException {
        for (IActor actor:
                this.actors) {
            actor.render(g);
        }
    }

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new Starter());
            container.setDisplayMode(WIDTH, HEIGHT, false);
            container.setTargetFrameRate(120);
            container.start();
        } catch (SlickException var2) {
            var2.printStackTrace();
        }

    }
}
