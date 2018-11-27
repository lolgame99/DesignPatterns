package main.interfaces;

public interface Observable {
    void addObserver(Observer observer);
    void informAll();
}
