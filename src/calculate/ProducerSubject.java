package calculate;

import java.util.ArrayList;
import java.util.List;

public class ProducerSubject {

    private final List<Observer> observers = new ArrayList<>();
    private Integer state;

    /**
     * state getter
     */
    public Integer getState() {
        return state;
    }

    /**
     * state setter
     */
    public Integer setState(final Integer state) {
        this.state = state;
        return notifyAllObservers();
    }

    /**
     * Attaches observer
     */
    public void attach(Observer observer) {
        observers.add(observer);
    }

    /**
     * Notify all the observers
     */
    public Integer notifyAllObservers() {
        for (Observer observer : observers) {
            return observer.update();
        }
        return 0;
    }
}
