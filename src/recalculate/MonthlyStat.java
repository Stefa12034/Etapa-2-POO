package recalculate;

import java.util.List;

public class MonthlyStat {

    private int month;
    private List<Integer> distributorsIds;

    public MonthlyStat(final int month, final List<Integer> distributorsIds) {
        this.month = month;
        this.distributorsIds = distributorsIds;
    }

    /**
     * month getter
     */
    public int getMonth() {
        return month;
    }

    /**
     * month setter
     */
    public void setMonth(final int month) {
        this.month = month;
    }

    /**
     * List of distributorsIds getter
     */
    public List<Integer> getDistributorsIds() {
        return distributorsIds;
    }

    /**
     * List of distributorsIds setter
     */
    public void setDistributorsIds(final List<Integer> distributorsIds) {
        this.distributorsIds = distributorsIds;
    }
}
