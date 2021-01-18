package strategies;

import calculate.RelInfoProducer;

import java.util.List;

public class EnergyStrategy {

    private final String energyType;
    private final int id;
    private final int quantityKW;
    private final List<RelInfoProducer> producers;

    public EnergyStrategy(final String energyType, final int id, final int quantityKW,
                          final List<RelInfoProducer> producers) {
        this.energyType = energyType;
        this.id = id;
        this.quantityKW = quantityKW;
        this.producers = producers;
    }

    /**
     * Returns the production cost given by a strategy
     */
    public int productionCost() {
        EnergyPrice energyPrice = null;
        if (energyType.equals("GREEN")) {
            energyPrice = new GreenStrategy();
        } else {
            if (energyType.equals("PRICE")) {
                energyPrice = new PriceStrategy();
            } else {
                if (energyType.equals("QUANTITY")) {
                    energyPrice = new QuantityStrategy();
                }
            }
        }
        assert energyPrice != null;
        return energyPrice.getProductionCost(quantityKW, producers, id);
    }
}
