package strategies;

import calculate.RelInfoProducer;

import java.util.List;

public class QuantityStrategy implements EnergyPrice {

    /**
     * Returns the production cost for the quantity strategy
     */
    @Override
    public int getProductionCost(int quantityKW, List<RelInfoProducer> producers, int id) {

        producers.sort((p1, p2) -> p2.getEnergyPerDistributor() - p1.getEnergyPerDistributor());
        return calculatePrice(producers, quantityKW, id);
    }

    /**
     * Calculates the production cost for the quantity strategy
     */
    @Override
    public int calculatePrice(List<RelInfoProducer> producers, int quantityKW, int id) {

        int quantityKWContor = 0;
        int i = 0;
        double price = 0;
        while (quantityKWContor < quantityKW) {

            if (producers.get(i).getMaxDistributors() > producers.get(i).getIds().size()) {

                price += producers.get(i).getEnergyPerDistributor()
                        * producers.get(i).getPriceKW();
                quantityKWContor += producers.get(i).getEnergyPerDistributor();
                producers.get(i).getIds().add(id);
            }
            i++;
        }
        return (int) Math.round(Math.floor(price / 10));
    }
}
