package parseinfo;

import java.util.List;

public class MonthlyUpdate {
    private List<Consumer> newConsumers;
    private List<CostsChange> costsChanges;

    /**
     * List of newConsumers getter
     */
    public List<Consumer> getNewConsumers() {
        return newConsumers;
    }

    /**
     * List of newConsumers setter
     */
    public void setNewConsumers(final List<Consumer> newConsumers) {
        this.newConsumers = newConsumers;
    }

    /**
     * List of constsChanges getter
     */
    public List<CostsChange> getCostsChanges() {
        return costsChanges;
    }

    /**
     * List of constsChanges setter
     */
    public void setCostsChanges(final List<CostsChange> costsChanges) {
        this.costsChanges = costsChanges;
    }
}
