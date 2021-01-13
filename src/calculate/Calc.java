package calculate;

import parseinfo.Script;
import recalculate.Contract;
import recalculate.RecalConsumer;
import recalculate.RecalDistributor;

import java.util.List;

public class Calc {
    private final Script script;
    private final List<RecalDistributor> recalDistributors;
    private final List<RecalConsumer> recalConsumers;
    private final List<RelInfoConsumer> relInfoConsumers;
    private final List<RelInfoDistributor> relInfoDistributors;

    public Calc(final Script script, final List<RecalDistributor> recalDistributors,
                final List<RecalConsumer> recalConsumers,
                final List<RelInfoConsumer> relInfoConsumers,
                final List<RelInfoDistributor> relInfoDistributors) {
        this.script = script;
        this.recalDistributors = recalDistributors;
        this.recalConsumers = recalConsumers;
        this.relInfoConsumers = relInfoConsumers;
        this.relInfoDistributors = relInfoDistributors;
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
     * Updates the data of all the distributors and consumers till the program ends
     */
    public void calculate() {

        Initialize initialize = new Initialize(script);
        Integer[] mins = initialize.newContract();

        for (int i = 0; i <= script.getNumberOfTurns(); i++) {

            if (i > 0) {
                for (int j = 0; j < script.getMonthlyUpdates().get(
                        i - 1).getCostsChanges().size(); j++) {
                    relInfoDistributors.get(script.getMonthlyUpdates().get(
                            i - 1).getCostsChanges().get(j).getId()).setInfrastructureCost(
                            script.getMonthlyUpdates().get(
                                    i - 1).getCostsChanges().get(j).getInfrastructureCost());
                    relInfoDistributors.get(script.getMonthlyUpdates().get(
                            i - 1).getCostsChanges().get(j).getId()).setProductionCost(
                            script.getMonthlyUpdates().get(
                                    i - 1).getCostsChanges().get(j).getProductionCost());
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

        for (RelInfoDistributor relInfoDistributor : relInfoDistributors) {
            recalDistributors.add(new RecalDistributor(relInfoDistributor.getId(),
                    relInfoDistributor.getBudget(), relInfoDistributor.isBankrupt(),
                    relInfoDistributor.getContracts()));
        }
    }
}
