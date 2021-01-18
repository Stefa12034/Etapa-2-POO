package parseinfo;

public class Producer {

    private int id;
    private String energyType;
    private int maxDistributors;
    private double priceKW;
    private int energyPerDistributor;

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
     * energyType getter
     */
    public String getEnergyType() {
        return energyType;
    }

    /**
     * energyType setter
     */
    public void setEnergyType(final String energyType) {
        this.energyType = energyType;
    }

    /**
     * maxDistributors getter
     */
    public int getMaxDistributors() {
        return maxDistributors;
    }

    /**
     * maxDistributors setter
     */
    public void setMaxDistributors(final int maxDistributors) {
        this.maxDistributors = maxDistributors;
    }

    /**
     * priceKW getter
     */
    public double getPriceKW() {
        return priceKW;
    }

    /**
     * priceKW setter
     */
    public void setPriceKW(final double priceKW) {
        this.priceKW = priceKW;
    }

    /**
     * energyPerDistributor getter
     */
    public int getEnergyPerDistributor() {
        return energyPerDistributor;
    }

    /**
     * energyPerDistributor setter
     */
    public void setEnergyPerDistributor(final int energyPerDistributor) {
        this.energyPerDistributor = energyPerDistributor;
    }
}
