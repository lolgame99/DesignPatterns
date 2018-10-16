package main;

import main.actors.Circle;
import main.interfaces.IMoveStrategy;
import main.strategy.MoveDown;
import main.strategy.MoveUp;
import org.newdawn.slick.*;

public class Starter extends BasicGame {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private Circle circle;
    private IMoveStrategy ms;

    public Starter() {
        super("Patterns");
    }

    @Override
    public void init(GameContainer gc) throws SlickException {
        this.ms = new MoveDown(100,100);
        this.circle = new Circle(ms);
    }

    @Override
    public void update(GameContainer gc, int d) throws SlickException {
        this.circle.move();
        if (this.circle.getIMoveStrategy().getY() >550){
            this.circle.setIMoveStrategy(new MoveUp(this.circle.getIMoveStrategy().getX(), this.circle.getIMoveStrategy().getY()));
        } else if (this.circle.getIMoveStrategy().getY() < 0){
            this.circle.setIMoveStrategy(new MoveDown(this.circle.getIMoveStrategy().getX(), this.circle.getIMoveStrategy().getY()));
        }

    }

    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException {
        this.circle.render(g);
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
