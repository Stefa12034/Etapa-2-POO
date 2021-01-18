package recalculate;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder({ "id", "energyNeededKW", "contractCost", "budget", "producerStrategy",
        "isBankrupt", "contracts"})
public class RecalDistributor {
    private int id;
    private int energyNeededKW;
    private int contractCost;
    private int budget;
    private String producerStrategy;
    private boolean isBankrupt;
    private List<Contract> contracts;

    public RecalDistributor(final int id, final int energyNeededKW,
                            final int contractCost, final int budget,
                            final String producerStrategy, final boolean isBankrupt,
                            final List<Contract> contracts) {
        this.id = id;
        this.energyNeededKW = energyNeededKW;
        this.contractCost = contractCost;
        this.budget = budget;
        this.producerStrategy = producerStrategy;
        this.isBankrupt = isBankrupt;
        this.contracts = contracts;
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
     * isBankrupt getter
     */
    public boolean getIsBankrupt() {
        return isBankrupt;
    }

    /**
     * isBankrupt setter
     */
    public void setBankrupt(final boolean bankrupt) {
        isBankrupt = bankrupt;
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
     * contractCost getter
     */
    public int getContractCost() {
        return contractCost;
    }

    /**
     * contractCost setter
     */
    public void setContractCost(final int contractCost) {
        this.contractCost = contractCost;
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
