package recalculate;

import java.util.List;

public abstract class Over {
    private List<RecalConsumer> consumers;
    private List<RecalDistributor> distributors;

    public Over(final List<RecalConsumer> consumers, final List<RecalDistributor> distributors) {
        this.consumers = consumers;
        this.distributors = distributors;
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
}
