package parseinfo;

import java.util.List;

public class InitialData {
    private List<Consumer> consumers;
    private List<Distributor> distributors;
    private List<Producer> producers;

    /**
     * List of consumers getter
     */
    public List<Consumer> getConsumers() {
        return consumers;
    }

    /**
     * List of consumers setter
     */
    public void setConsumers(final List<Consumer> consumers) {
        this.consumers = consumers;
    }

    /**
     * List of distributors getter
     */
    public List<Distributor> getDistributors() {
        return distributors;
    }

    /**
     * List of distributors setter
     */
    public void setDistributors(final List<Distributor> distributors) {
        this.distributors = distributors;
    }

    /**
     * List of producers getter
     */
    public List<Producer> getProducers() {
        return producers;
    }

    /**
     * List of producers setter
     */
    public void setProducers(final List<Producer> producers) {
        this.producers = producers;
    }
}
