package recalculate;

import java.util.List;

public class RecalProducer {

    private int id;
    private int maxDistributors;
    private double priceKW;
    private String energyType;
    private int energyPerDistributor;
    private List<MonthlyStat> monthlyStats;

    public RecalProducer(final int id, final int maxDistributors, final double priceKW,
                         final String energyType, final int energyPerDistributor,
                         final List<MonthlyStat> monthlyStats) {
        this.id = id;
        this.maxDistributors = maxDistributors;
        this.priceKW = priceKW;
        this.energyType = energyType;
        this.energyPerDistributor = energyPerDistributor;
        this.monthlyStats = monthlyStats;
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
     * energyPerDistributor getter
     */
    public int getEnergyPerDistributor() {
        return energyPerDistributor;
    }

    /**
     * energyPerDistributor setter
     */
    public void setEnergyPerDistributor(int energyPerDistributor) {
        this.energyPerDistributor = energyPerDistributor;
    }

    /**
     * List of monthlyStat getter
     */
    public List<MonthlyStat> getMonthlyStats() {
        return monthlyStats;
    }

    /**
     * List of monthlyStat setter
     */
    public void setMonthlyStats(final List<MonthlyStat> monthlyStats) {
        this.monthlyStats = monthlyStats;
    }
}
