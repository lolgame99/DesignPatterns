package main.interfaces;

import org.newdawn.slick.Graphics;

public interface IActor {
    void move();
    void render(Graphics G);
    IMoveStrategy getIMoveStrategy();
    void setIMoveStrategy(IMoveStrategy moveStrategy);
}
