package main.interfaces;

public interface IMoveStrategy {
    void move();
    int getX();
    int getY();
    void setX(int x);
    void setY(int y);
}
