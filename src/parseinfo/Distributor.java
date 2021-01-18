package parseinfo;

public class Distributor {
    private int id;
    private int contractLength;
    private int initialBudget;
    private int initialInfrastructureCost;
    private int energyNeededKW;
    private String producerStrategy;

    /**
     * id getter
     */
    public int getId() {
        return id;
    }

    /**
     * id setter
     */
    public void setId(final int id) {
        this.id = id;
    }

    /**
     * contractLength getter
     */
    public int getContractLength() {
        return contractLength;
    }

    /**
     * contractLength setter
     */
    public void setContractLength(final int contractLength) {
        this.contractLength = contractLength;
    }

    /**
     * initialBudget getter
     */
    public int getInitialBudget() {
        return initialBudget;
    }

    /**
     * initialBudget setter
     */
    public void setInitialBudget(final int initialBudget) {
        this.initialBudget = initialBudget;
    }

    /**
     * infrastructureCost getter
     */
    public int getInitialInfrastructureCost() {
        return initialInfrastructureCost;
    }

    /**
     * infrastructureCost setter
     */
    public void setInitialInfrastructureCost(final int initialInfrastructureCost) {
        this.initialInfrastructureCost = initialInfrastructureCost;
    }

    /**
     * energyNeededKW getter
     */
    public int getEnergyNeededKW() {
        return energyNeededKW;
    }

    /**
     * energyNeededKW setter
     */
    public void setEnergyNeededKW(final int energyNeededKW) {
        this.energyNeededKW = energyNeededKW;
    }

    /**
     * producerStrategy getter
     */
    public String getProducerStrategy() {
        return producerStrategy;
    }

    /**
     * producerStrategy setter
     */
    public void setProducerStrategy(final String producerStrategy) {
        this.producerStrategy = producerStrategy;
    }
}
