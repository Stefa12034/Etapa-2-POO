package recalculate;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder({ "id", "budget", "isBankrupt", "contracts"})
public class RecalDistributor {
    private int id;
    private int budget;
    private boolean isBankrupt;
    private List<Contract> contracts;

    public RecalDistributor(final int id, final int budget, final boolean isBankrupt,
                            final List<Contract> contracts) {
        this.id = id;
        this.budget = budget;
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
}
