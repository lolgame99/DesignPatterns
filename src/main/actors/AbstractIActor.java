package main.actors;

import main.interfaces.IActor;
import main.interfaces.IMoveStrategy;

public abstract class AbstractIActor implements IActor {
    protected IMoveStrategy IMoveStrategy;

    public AbstractIActor(IMoveStrategy IMoveStrategy) {
        this.IMoveStrategy = IMoveStrategy;
    }

    public void setIMoveStrategy(IMoveStrategy IMoveStrategy) {
        this.IMoveStrategy = IMoveStrategy;
    }

    public IMoveStrategy getIMoveStrategy() {
        return IMoveStrategy;
    }
}
