package recalculate;

public class Contract {
    private int consumerId;
    private int price;
    private int remainedContractMonths;

    public Contract(final int consumerId, final int price, final int remainedContractMonths) {
        this.consumerId = consumerId;
        this.price = price;
        this.remainedContractMonths = remainedContractMonths;
    }

    /**
     * consumerId getter
     */
    public int getConsumerId() {
        return consumerId;
    }

    /**
     * consumerId setter
     */
    public void setConsumerId(final int consumerId) {
        this.consumerId = consumerId;
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
     * remainedContractMonths getter
     */
    public int getRemainedContractMonths() {
        return remainedContractMonths;
    }

    /**
     * remainedContractMonths setter
     */
    public void setRemainedContractMonths(final int remainedContractMonths) {
        this.remainedContractMonths = remainedContractMonths;
    }
}
