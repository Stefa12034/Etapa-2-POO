package calculate;

import recalculate.Contract;

import java.util.List;

public class RelInfoDistributor {
    private int id;
    private int budget;
    private int contractSize;
    private int infrastructureCost;
    private int productionCost;
    private boolean isBankrupt;
    private List<Contract> contracts;

    public RelInfoDistributor(final int id, final int budget, final int contractSize,
                              final int infrastructureCost, final int productionCost,
                              final boolean isBankrupt, final List<Contract> contracts) {
        this.id = id;
        this.budget = budget;
        this.contractSize = contractSize;
        this.infrastructureCost = infrastructureCost;
        this.productionCost = productionCost;
        this.isBankrupt = isBankrupt;
        this.contracts = contracts;
    }

    /**
     * Removes the contract with the id idConsumer from the contracts list
     */
    public void removeContract(final int idConsumer) {
        for (int i = 0; i < contracts.size(); i++) {
            if (contracts.get(i).getConsumerId() == idConsumer) {
                contracts.remove(i);
                break;
            }
        }
    }

    /**
     * List of contracts getter
     */
    public List<Contract> getContracts() {
        return contracts;
    }

    /**
     * List of contracts setter
     */
    public void setContracts(final List<Contract> contracts) {
        this.contracts = contracts;
    }

    /**
     * isBankrupt getter
     */
    public boolean isBankrupt() {
        return isBankrupt;
    }

    /**
     * isBankrupt setter
     */
    public void setBankrupt(final boolean bankrupt) {
        isBankrupt = bankrupt;
    }

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
     * budget getter
     */
    public int getBudget() {
        return budget;
    }

    /**
     * budget setter
     */
    public void setBudget(final int budget) {
        this.budget = budget;
    }

    /**
     * contractSize getter
     */
    public int getContractSize() {
        return contractSize;
    }

    /**
     * contractSize setter
     */
    public void setContractSize(final int contractSize) {
        this.contractSize = contractSize;
    }

    /**
     * infrastructureCost getter
     */
    public int getInfrastructureCost() {
        return infrastructureCost;
    }

    /**
     * infrastructureCost setter
     */
    public void setInfrastructureCost(final int infrastructureCost) {
        this.infrastructureCost = infrastructureCost;
    }

    /**
     * productionCost getter
     */
    public int getProductionCost() {
        return productionCost;
    }

    /**
     * productionCost setter
     */
    public void setProductionCost(final int productionCost) {
        this.productionCost = productionCost;
    }
}
