package parseinfo;

public class CostsChange {
    private int id;
    private int infrastructureCost;
    private int productionCost;

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
