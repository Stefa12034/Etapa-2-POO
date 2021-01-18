package calculate;

import parseinfo.Script;
import recalculate.*;
import strategies.EnergyStrategy;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Calc {
    private final Script script;
    private final List<RecalDistributor> recalDistributors;
    private final List<RecalConsumer> recalConsumers;
    private final List<RecalProducer> recalProducers;
    private final List<RelInfoConsumer> relInfoConsumers;
    private final List<RelInfoDistributor> relInfoDistributors;
    private final List<RelInfoProducer> relInfoProducers;

    public Calc(final Script script, final List<RecalDistributor> recalDistributors,
                final List<RecalConsumer> recalConsumers,
                final List<RecalProducer> recalProducers,
                final List<RelInfoConsumer> relInfoConsumers,
                final List<RelInfoDistributor> relInfoDistributors,
                final List<RelInfoProducer> relInfoProducers) {
        this.script = script;
        this.recalDistributors = recalDistributors;
        this.recalConsumers = recalConsumers;
        this.recalProducers = recalProducers;
        this.relInfoConsumers = relInfoConsumers;
        this.relInfoDistributors = relInfoDistributors;
        this.relInfoProducers = relInfoProducers;
    }

    /**
     * Updates the data of a consumer monthly
     */
    public void updateConsumerData(final Integer[] mins, final int j) {

        if (!relInfoConsumers.get(j).isBankrupt()) {
            relInfoConsumers.get(j).setBudget(relInfoConsumers.get(j).getBudget()
                    + relInfoConsumers.get(j).getIncome());

            if (relInfoConsumers.get(j).getRemainedMonths() == 0) {
                relInfoDistributors.get(
                        relInfoConsumers.get(j).getIdDistributor()).removeContract(j);

                if (mins[1] != relInfoConsumers.get(j).getIdDistributor()) {
                    relInfoDistributors.get(
                            relInfoConsumers.get(j).getIdDistributor()).setContractSize(
                            relInfoDistributors.get(relInfoConsumers.get(
                                    j).getIdDistributor()).getContractSize() - 1);
                    relInfoDistributors.get(mins[1]).setContractSize(relInfoDistributors.get(
                            mins[1]).getContractSize() + 1);
                }

                relInfoConsumers.get(j).setPrice(mins[0]);
                relInfoConsumers.get(j).setIdDistributor(mins[1]);
                relInfoConsumers.get(j).setRemainedMonths(
                        script.getInitialData().getDistributors().get(
                        relInfoConsumers.get(j).getIdDistributor()).getContractLength());
                relInfoDistributors.get(relInfoConsumers.get(
                        j).getIdDistributor()).getContracts().add(new Contract(
                        j, mins[0], relInfoConsumers.get(j).getRemainedMonths()));
            }
            relInfoConsumers.get(j).setRemainedMonths(
                    relInfoConsumers.get(j).getRemainedMonths() - 1);

            if (!relInfoConsumers.get(j).isRestant()) {

                if (relInfoConsumers.get(j).getBudget() < relInfoConsumers.get(j).getPrice()) {
                    relInfoConsumers.get(j).setRestant(true);
                    relInfoConsumers.get(j).setOldPrice(relInfoConsumers.get(j).getPrice());
                } else {

                    relInfoConsumers.get(j).setBudget(relInfoConsumers.get(j).getBudget()
                            - relInfoConsumers.get(j).getPrice());
                    relInfoDistributors.get(relInfoConsumers.get(j).getIdDistributor()).setBudget(
                            relInfoDistributors.get(
                                    relInfoConsumers.get(j).getIdDistributor()).getBudget()
                                    + relInfoConsumers.get(j).getPrice());
                }

            } else {

                if (relInfoConsumers.get(j).getBudget() < Math.round(Math.floor(1.2
                        * relInfoConsumers.get(j).getOldPrice()))
                        + relInfoConsumers.get(j).getPrice()) {
                    relInfoConsumers.get(j).setBankrupt(true);
                    relInfoDistributors.get(
                            relInfoConsumers.get(j).getIdDistributor()).removeContract(j);
                } else {

                    relInfoConsumers.get(j).setRestant(false);
                    relInfoConsumers.get(j).setBudget((int) (relInfoConsumers.get(j).getBudget()
                            - Math.round(Math.floor(1.2 * relInfoConsumers.get(j).getOldPrice()))
                            - relInfoConsumers.get(j).getPrice()));
                }
            }
        }

    }

    /**
     * Remove the distributor id from all producers
     */
    void removeIds(Integer id) {

        for (RelInfoProducer relInfoProducer : relInfoProducers) {
            relInfoProducer.getIds().remove(id);
        }
    }

    /**
     * Updates the data of all the distributors and consumers till the program ends
     */
    public void calculate() {

        Initialize initialize = new Initialize(script);
        Integer[] mins = initialize.newContract(relInfoDistributors);
        for (int i = 1; i <= script.getNumberOfTurns(); i++) {

            for (RelInfoProducer relInfoProducer : relInfoProducers) {
                relInfoProducer.getMonthlyStats().add(new MonthlyStat(i, new LinkedList<>()));
            }
        }

        for (int i = 0; i <= script.getNumberOfTurns(); i++) {
            if (i > 0) {
                for (int j = 0; j < script.getMonthlyUpdates().get(
                        i - 1).getDistributorChanges().size(); j++) {

                    relInfoDistributors.get(script.getMonthlyUpdates().get(
                            i - 1).getDistributorChanges().get(j).getId()).setInfrastructureCost(
                            script.getMonthlyUpdates().get(
                                    i - 1).getDistributorChanges().get(j).getInfrastructureCost());
                }

                for (RelInfoDistributor relInfoDistributor : relInfoDistributors) {

                    int profit = (int) Math.round(Math.floor(0.2
                            * relInfoDistributor.getProductionCost()));
                    if (relInfoDistributor.getContractSize() != 0) {

                        relInfoDistributor.setContractCost(
                                relInfoDistributor.getInfrastructureCost()
                                / relInfoDistributor.getContractSize()
                                + relInfoDistributor.getProductionCost() + profit);
                    } else {

                        relInfoDistributor.setContractCost(
                                relInfoDistributor.getInfrastructureCost()
                                + relInfoDistributor.getProductionCost() + profit);
                    }
                }
                mins = initialize.renewContract(relInfoDistributors);
            }

            for (int j = 0; j < relInfoConsumers.size(); j++) {
                updateConsumerData(mins, j);
            }

            if (i > 0) {
                for (int j = 0; j < script.getMonthlyUpdates().get(
                        i - 1).getNewConsumers().size(); j++) {

                    relInfoDistributors.get(mins[1]).setContractSize(
                            relInfoDistributors.get(mins[1]).getContractSize() + 1);
                    relInfoDistributors.get(mins[1]).getContracts().add(new Contract(
                            script.getMonthlyUpdates().get(i - 1).getNewConsumers().get(j).getId(),
                            mins[0], script.getInitialData().getDistributors().get(
                            mins[1]).getContractLength()));
                    relInfoConsumers.add(new RelInfoConsumer(script.getMonthlyUpdates().get(
                            i - 1).getNewConsumers().get(j).getId(),
                            mins[0], script.getInitialData().getDistributors().get(
                            mins[1]).getContractLength(),
                            script.getMonthlyUpdates().get(
                                    i - 1).getNewConsumers().get(j).getInitialBudget(),
                            script.getMonthlyUpdates().get(
                                    i - 1).getNewConsumers().get(j).getMonthlyIncome(),
                            mins[1], false, false, 0));
                }

                for (int j = relInfoConsumers.size()
                        - script.getMonthlyUpdates().get(i - 1).getNewConsumers().size();
                     j < relInfoConsumers.size(); j++) {

                    if (!relInfoConsumers.get(j).isBankrupt()) {
                        updateConsumerData(mins, j);
                    }
                }
            }
            boolean ok = true;

            for (RelInfoDistributor infoDistributor : relInfoDistributors) {
                if (!infoDistributor.isBankrupt()) {

                    ok = false;
                    infoDistributor.setBudget(infoDistributor.getBudget()
                            - infoDistributor.getInfrastructureCost()
                            - infoDistributor.getProductionCost()
                            * infoDistributor.getContractSize());
                    infoDistributor.setContractSize(infoDistributor.getContracts().size());

                    if (infoDistributor.getBudget() < 0) {
                        infoDistributor.setBankrupt(true);
                    }
                }
            }

            if (ok) {
                for (RelInfoDistributor relInfoDistributor : relInfoDistributors) {
                    relInfoDistributor.getContracts().clear();
                }
                break;
            }

            if (i > 0) {
                List<Integer> idsCopy = new LinkedList<>();

                for (int j = 0; j < script.getMonthlyUpdates().get(
                        i - 1).getProducerChanges().size(); j++) {

                    relInfoProducers.sort(Comparator.comparingInt(RelInfoProducer::getId));
                    relInfoProducers.get(script.getMonthlyUpdates().get(
                            i - 1).getProducerChanges().get(j).getId()).setEnergyPerDistributor(
                            script.getMonthlyUpdates().get(
                                    i - 1).getProducerChanges().get(j).getEnergyPerDistributor());
                    idsCopy.addAll(relInfoProducers.get(script.getMonthlyUpdates().get(
                            i - 1).getProducerChanges().get(j).getId()).getIds());
                }

                idsCopy.sort(Comparator.comparingInt(p -> p));
                for (Integer integer : idsCopy) {

                    removeIds(integer);
                    EnergyStrategy energyStrategy = new EnergyStrategy(
                            script.getInitialData().getDistributors().get(
                                    integer).getProducerStrategy(),
                            integer, script.getInitialData().getDistributors().get(
                                    integer).getEnergyNeededKW(),
                            relInfoProducers);
                    int productionCost = energyStrategy.productionCost();
                    relInfoDistributors.get(integer).setProductionCost(productionCost);
                }
            }

            if (i > 0) {
                for (RelInfoProducer relInfoProducer : relInfoProducers) {

                    relInfoProducer.setIds(relInfoProducer.getIds().stream().distinct().collect(
                            Collectors.toList()));
                    relInfoProducer.getMonthlyStats().get(i - 1).setDistributorsIds(
                            new LinkedList<>(relInfoProducer.getIds()));
                }
            }
        }

        for (int i = 0; i < relInfoConsumers.size(); i++) {
            recalConsumers.add(new RecalConsumer(relInfoConsumers.get(i).getIdConsumer(),
                    relInfoConsumers.get(i).isBankrupt(), relInfoConsumers.get(i).getBudget()));

            for (int j = 0; j < relInfoDistributors.get(
                    relInfoConsumers.get(i).getIdDistributor()).getContracts().size(); j++) {

                if (relInfoDistributors.get(
                        relInfoConsumers.get(i).getIdDistributor()).getContracts().get(
                                j).getConsumerId() == i) {
                    relInfoDistributors.get(
                            relInfoConsumers.get(i).getIdDistributor()).getContracts().get(
                                    j).setRemainedContractMonths(
                            relInfoConsumers.get(i).getRemainedMonths());
                    break;
                }
            }
        }

        for (int i = 0; i < relInfoDistributors.size(); i++) {

            recalDistributors.add(new RecalDistributor(relInfoDistributors.get(i).getId(),
                    script.getInitialData().getDistributors().get(i).getEnergyNeededKW(),
                    relInfoDistributors.get(i).getContractCost(),
                    relInfoDistributors.get(i).getBudget(),
                    script.getInitialData().getDistributors().get(i).getProducerStrategy(),
                    relInfoDistributors.get(i).isBankrupt(),
                    relInfoDistributors.get(i).getContracts()));
        }

        for (int i = 0; i < relInfoProducers.size(); i++) {

            recalProducers.add(new RecalProducer(relInfoProducers.get(i).getId(),
                    relInfoProducers.get(i).getMaxDistributors(),
                    relInfoProducers.get(i).getPriceKW(),
                    relInfoProducers.get(i).getEnergyType(),
                    relInfoProducers.get(i).getEnergyPerDistributor(),
                    relInfoProducers.get(i).getMonthlyStats()));

            for (int j = 0; j < recalProducers.get(i).getMonthlyStats().size(); j++) {
                recalProducers.get(i).getMonthlyStats().get(j).getDistributorsIds().sort(
                        Comparator.comparingInt(o -> o));
            }
        }
        recalProducers.sort(Comparator.comparingInt(RecalProducer::getId));
    }
}
