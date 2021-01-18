package calculate;


public class DistributorObserver extends Observer {

    public DistributorObserver(final ProducerSubject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    /**
     * Updates the list of ids
     */
    @Override
    public Integer update() {
        return subject.getState();
    }
}
