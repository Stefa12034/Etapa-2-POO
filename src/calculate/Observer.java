package calculate;

public abstract class Observer {
    protected ProducerSubject subject;

    /**
     * Updates the list of ids
     */
    public abstract Integer update();
}
