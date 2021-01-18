package strategies;

import calculate.RelInfoProducer;
import entities.EnergyType;

import java.util.List;

public class GreenStrategy implements EnergyPrice {

    /**
     * Returns the production cost for the green strategy
     */
    @Override
    public int getProductionCost(int quantityKW, List<RelInfoProducer> producers, int id) {

        producers.sort((p1, p2) -> {

            if (EnergyType.valueOf(p1.getEnergyType()).isRenewable()
                    && !EnergyType.valueOf(p2.getEnergyType()).isRenewable()) {
                return -1;
            } else {

                if (!EnergyType.valueOf(p1.getEnergyType()).isRenewable()
                        && EnergyType.valueOf(p2.getEnergyType()).isRenewable()) {
                    return 1;
                } else {

                    if (p1.getPriceKW() > p2.getPriceKW()) {
                        return 1;
                    } else {

                        if ((p1.getPriceKW() == p2.getPriceKW())
                                && (p2.getEnergyPerDistributor()
                                        > p1.getEnergyPerDistributor())) {
                            return 1;
                        } else {

                            if (p2.getEnergyPerDistributor() == p1.getEnergyPerDistributor()) {
                                return 0;
                            } else {

                                return -1;
                            }
                        }
                    }
                }
            }
        });
        return calculatePrice(producers, quantityKW, id);
    }

    /**
     * Calculates the production cost for the green strategy
     */
    @Override
    public int calculatePrice(final List<RelInfoProducer> producers, int quantityKW, int id) {

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
