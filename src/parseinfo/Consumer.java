package parseinfo;

public class Consumer {
    private int id;
    private int initialBudget;
    private int monthlyIncome;

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
     * monthlyIncome getter
     */
    public int getMonthlyIncome() {
        return monthlyIncome;
    }

    /**
     * monthlyIncome setter
     */
    public void setMonthlyIncome(final int monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }
}
