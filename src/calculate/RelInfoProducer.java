package calculate;

import recalculate.MonthlyStat;

import java.util.List;

public class RelInfoProducer {

    private int id;
    private String energyType;
    private int maxDistributors;
    private double priceKW;
    private int energyPerDistributor;
    private List<Integer> ids;
    private List<MonthlyStat> monthlyStats;


    public RelInfoProducer(final int id, final String energyType, final int maxDistributors,
                           final double priceKW, final int energyPerDistributor,
                           final List<Integer> ids, final List<MonthlyStat> monthlyStats) {
        this.id = id;
        this.energyType = energyType;
        this.maxDistributors = maxDistributors;
        this.priceKW = priceKW;
        this.energyPerDistributor = energyPerDistributor;
        this.ids = ids;
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

    /**
     * List of distributor ids getter
     */
    public List<Integer> getIds() {
        return ids;
    }

    /**
     * List of distributor ids setter
     */
    public void setIds(final List<Integer> ids) {
        this.ids = ids;
    }

    /**
     * List of monthlyStats getter
     */
    public List<MonthlyStat> getMonthlyStats() {
        return monthlyStats;
    }

    /**
     * List of monthlyStats setter
     */
    public void setMonthlyStats(final List<MonthlyStat> monthlyStats) {
        this.monthlyStats = monthlyStats;
    }
}
