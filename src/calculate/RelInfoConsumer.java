package calculate;

public class RelInfoConsumer {
    private int idConsumer;
    private int price;
    private int remainedMonths;
    private int budget;
    private int income;
    private int idDistributor;
    private boolean isBankrupt;
    private boolean isRestant;
    private int oldPrice;

    public RelInfoConsumer(final int id, final int price, final int remainedMonths,
                           final int budget, final int income, final int idDistributor,
                           final boolean isBankrupt, final boolean isRestant, final int oldPrice) {
        this.idConsumer = id;
        this.price = price;
        this.remainedMonths = remainedMonths;
        this.budget = budget;
        this.income = income;
        this.idDistributor = idDistributor;
        this.isBankrupt = isBankrupt;
        this.isRestant = isRestant;
        this.oldPrice = oldPrice;
    }

    /**
     * oldPrice getter
     */
    public int getOldPrice() {
        return oldPrice;
    }

    /**
     * oldPrice setter
     */
    public void setOldPrice(final int oldPrice) {
        this.oldPrice = oldPrice;
    }

    /**
     * isRestant getter
     */
    public boolean isRestant() {
        return isRestant;
    }

    /**
     * isRestant setter
     */
    public void setRestant(final boolean restant) {
        isRestant = restant;
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
     * idDistributor getter
     */
    public int getIdDistributor() {
        return idDistributor;
    }

    /**
     * idDistributor setter
     */
    public void setIdDistributor(final int idDistributor) {
        this.idDistributor = idDistributor;
    }

    /**
     * idConsumer getter
     */
    public int getIdConsumer() {
        return idConsumer;
    }

    /**
     * idConsumer setter
     */
    public void setIdConsumer(final int idConsumer) {
        this.idConsumer = idConsumer;
    }

    /**
     * price getter
     */
    public int getPrice() {
        return price;
    }

    /**
     * price setter
     */
    public void setPrice(final int price) {
        this.price = price;
    }

    /**
     * remainedMonths getter
     */
    public int getRemainedMonths() {
        return remainedMonths;
    }

    /**
     * remainedMonths setter
     */
    public void setRemainedMonths(final int remainedMonths) {
        this.remainedMonths = remainedMonths;
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
     * income getter
     */
    public int getIncome() {
        return income;
    }

    /**
     * income setter
     */
    public void setIncome(final int income) {
        this.income = income;
    }
}
