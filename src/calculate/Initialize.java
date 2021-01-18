package calculate;

import parseinfo.Script;
import recalculate.Contract;
import strategies.*;

import java.util.LinkedList;
import java.util.List;

public class Initialize {
    private final Script script;

    public Initialize(final Script script) {
        this.script = script;
    }

    /**
     * Initialize the list of RelInfoProducers
     */
    public List<RelInfoProducer> initRelInfoProducers() {

        List<RelInfoProducer> relInfoProducers = new LinkedList<>();
        for (int i = 0; i < script.getInitialData().getProducers().size(); i++) {

            relInfoProducers.add(new RelInfoProducer(
                    script.getInitialData().getProducers().get(i).getId(),
                    script.getInitialData().getProducers().get(i).getEnergyType(),
                    script.getInitialData().getProducers().get(i).getMaxDistributors(),
                    script.getInitialData().getProducers().get(i).getPriceKW(),
                    script.getInitialData().getProducers().get(i).getEnergyPerDistributor(),
                    new LinkedList<>(), new LinkedList<>()));
        }
        return relInfoProducers;
    }

    /**
     * Initialize the list of RelInfoDistributors
     */
    public List<RelInfoDistributor> initRelInfoDistributors(
            final List<RelInfoProducer> relInfoProducers) {

        List<RelInfoDistributor> relInfoDistributors = new LinkedList<>();
        for (int i = 0; i < script.getInitialData().getDistributors().size(); i++) {

            EnergyStrategy energyStrategy = new EnergyStrategy(
                    script.getInitialData().getDistributors().get(i).getProducerStrategy(), i,
                    script.getInitialData().getDistributors().get(i).getEnergyNeededKW(),
                    relInfoProducers);
            int productionCost = energyStrategy.productionCost();
            relInfoDistributors.add(new RelInfoDistributor(
                    script.getInitialData().getDistributors().get(i).getId(),
                    script.getInitialData().getDistributors().get(i).getInitialBudget(), 0,
                    script.getInitialData().getDistributors().get(
                            i).getInitialInfrastructureCost(),
                    productionCost, false, new LinkedList<>(), 0));
        }
        return relInfoDistributors;
    }

    /**
     * Gives the min cost of the contract and his ditributor id every month
     */
    public Integer[] renewContract(final List<RelInfoDistributor> relInfoDistributors) {
        int minCost = (int) Double.POSITIVE_INFINITY;
        int minIndex = 0;

        for (int j = 0; j < script.getInitialData().getDistributors().size(); j++) {

            if (!relInfoDistributors.get(j).isBankrupt()) {
                int cost;
                int profit = (int) Math.round(Math.floor(0.2
                        * relInfoDistributors.get(j).getProductionCost()));

                if (relInfoDistributors.get(j).getContractSize() == 0) {
                    cost = relInfoDistributors.get(j).getInfrastructureCost()
                            + relInfoDistributors.get(j).getProductionCost() + profit;
                } else {
                    cost = relInfoDistributors.get(j).getInfrastructureCost()
                            / relInfoDistributors.get(j).getContractSize()
                            + relInfoDistributors.get(j).getProductionCost() + profit;
                }

                if (minCost > cost) {
                    minCost = cost;
                    minIndex = j;

                }

            }
        }

        Integer[] mins = new Integer[2];
        mins[0] = minCost;
        mins[1] = minIndex;

        relInfoDistributors.get(mins[1]).setContractCost(mins[0]);
        return mins;
    }

    /**
     * Gives the min cost of the contract and his ditributor id at the beginning
     */
    public Integer[] newContract(List<RelInfoDistributor> relInfoDistributors) {
        int minCost = (int) Double.POSITIVE_INFINITY;
        int minIndex = 0;

        for (int j = 0; j < script.getInitialData().getDistributors().size(); j++) {
            int cost;
            int profit = (int) Math.round(Math.floor(0.2
                    * relInfoDistributors.get(j).getProductionCost()));
            cost = script.getInitialData().getDistributors().get(j).getInitialInfrastructureCost()
                    + relInfoDistributors.get(j).getProductionCost() + profit;

            if (minCost > cost) {
                minCost = cost;
                minIndex = j;
            }
        }

        Integer[] mins = new Integer[2];
        mins[0] = minCost;
        mins[1] = minIndex;

        relInfoDistributors.get(mins[1]).setContractCost(mins[0]);
        return mins;

    }

    /**
     * Initialize the list of RelInfoConsumers
     */
    public List<RelInfoConsumer> initRelInfoConsumers(
            final List<RelInfoDistributor> relInfoDistributors) {

        List<RelInfoConsumer> relInfoConsumers = new LinkedList<>();
        Integer[] mins = newContract(relInfoDistributors);
        for (int i = 0; i < script.getInitialData().getConsumers().size(); i++) {

            relInfoDistributors.get(mins[1]).setContractSize(
                    relInfoDistributors.get(mins[1]).getContractSize() + 1);
            relInfoDistributors.get(mins[1]).getContracts().add(
                    new Contract(script.getInitialData().getConsumers().get(i).getId(), mins[0],
                            script.getInitialData().getDistributors().get(
                                    mins[1]).getContractLength()));
            relInfoConsumers.add(
                    new RelInfoConsumer(script.getInitialData().getConsumers().get(i).getId(),
                    mins[0], script.getInitialData().getDistributors().get(
                            mins[1]).getContractLength(),
                    script.getInitialData().getConsumers().get(i).getInitialBudget(),
                    script.getInitialData().getConsumers().get(i).getMonthlyIncome(),
                    mins[1], false, false, 0));
        }
        return relInfoConsumers;
    }
}
