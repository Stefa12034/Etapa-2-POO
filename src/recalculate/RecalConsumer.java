package recalculate;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "id", "isBankrupt", "budget" })
public class RecalConsumer {
    private int id;
    private boolean isBankrupt;
    private int budget;

    public RecalConsumer(final int id, final boolean isBankrupt, final int budget) {
        this.id = id;
        this.isBankrupt = isBankrupt;
        this.budget = budget;
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

}
