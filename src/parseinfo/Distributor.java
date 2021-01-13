package parseinfo;

public class Distributor {
    private int id;
    private int contractLength;
    private int initialBudget;
    private int initialInfrastructureCost;
    private int initialProductionCost;

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
     * productionCost getter
     */
    public int getInitialProductionCost() {
        return initialProductionCost;
    }

    /**
     * productionCost setter
     */
    public void setInitialProductionCost(final int initialProductionCost) {
        this.initialProductionCost = initialProductionCost;
    }
}
