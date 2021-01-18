package parseinfo;

import java.util.List;

public class MonthlyUpdate {
    private List<Consumer> newConsumers;
    private List<DistributorChanges> distributorChanges;
    private List<ProducerChanges> producerChanges;

    /**
     * List of newConsumers getter
     */
    public List<Consumer> getNewConsumers() {
        return newConsumers;
    }

    /**
     * List of newConsumers setter
     */
    public void setNewConsumers(final List<Consumer> newConsumers) {
        this.newConsumers = newConsumers;
    }

    /**
     * List of constsChanges getter
     */
    public List<DistributorChanges> getDistributorChanges() {
        return distributorChanges;
    }

    /**
     * List of constsChanges setter
     */
    public void setDistributorChanges(final List<DistributorChanges> distributorChanges) {
        this.distributorChanges = distributorChanges;
    }

    /**
     * List of producerChange getter
     */
    public List<ProducerChanges> getProducerChanges() {
        return producerChanges;
    }

    /**
     * List of producerChanges setter
     */
    public void setProducerChanges(List<ProducerChanges> producerChanges) {
        this.producerChanges = producerChanges;
    }
}
