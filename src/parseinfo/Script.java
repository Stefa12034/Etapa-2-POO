package parseinfo;

import java.util.List;

public class Script {
    private int numberOfTurns;
    private InitialData initialData;
    private List<MonthlyUpdate> monthlyUpdates;

    /**
     * numberOfTurns getter
     */
    public int getNumberOfTurns() {
        return numberOfTurns;
    }

    /**
     * numberOfTurns setter
     */
    public void setNumberOfTurns(final int numberOfTurns) {
        this.numberOfTurns = numberOfTurns;
    }

    /**
     * initialData getter
     */
    public InitialData getInitialData() {
        return initialData;
    }

    /**
     * initialData setter
     */
    public void setInitialData(final InitialData initialData) {
        this.initialData = initialData;
    }

    /**
     * List of monthly updates getter
     */
    public List<MonthlyUpdate> getMonthlyUpdates() {
        return monthlyUpdates;
    }

    /**
     * List of monthly updates setter
     */
    public void setMonthlyUpdates(final List<MonthlyUpdate> monthlyUpdates) {
        this.monthlyUpdates = monthlyUpdates;
    }
}
