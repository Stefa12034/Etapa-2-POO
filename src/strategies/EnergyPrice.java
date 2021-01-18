package strategies;

import calculate.RelInfoProducer;
import java.util.List;

public interface EnergyPrice {

    /**
     * Returns the production cost for a distributor
     */
    int getProductionCost(int quantityKW,
                                 List<RelInfoProducer> producers, int id);

    /**
     * Calculates the price of the production cost
     */
    int calculatePrice(List<RelInfoProducer> producers, int quantityKW, int id);
}
