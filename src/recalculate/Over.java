package recalculate;

import java.util.List;

public abstract class Over {
    private List<RecalConsumer> consumers;
    private List<RecalDistributor> distributors;
    private List<RecalProducer> energyProducers;

    public Over(final List<RecalConsumer> consumers, final List<RecalDistributor> distributors,
                final List<RecalProducer> energyProducers) {
        this.consumers = consumers;
        this.distributors = distributors;
        this.energyProducers = energyProducers;
    }

    /**
     * List of RecalConsumers getter
     */
    public List<RecalConsumer> getConsumers() {
        return consumers;
    }

    /**
     * List of RecalConsumers setter
     */
    public void setConsumers(final List<RecalConsumer> consumers) {
        this.consumers = consumers;
    }

    /**
     * List of RecalDistributors getter
     */
    public List<RecalDistributor> getDistributors() {
        return distributors;
    }

    /**
     * List of RecalDistributors setter
     */
    public void setDistributors(final List<RecalDistributor> distributors) {
        this.distributors = distributors;
    }

    /**
     * List of energyProducer getter
     */
    public List<RecalProducer> getEnergyProducers() {
        return energyProducers;
    }

    /**
     * List of energyProducer setter
     */
    public void setEnergyProducers(final List<RecalProducer> energyProducers) {
        this.energyProducers = energyProducers;
    }
}
