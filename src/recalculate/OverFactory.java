package recalculate;

import java.util.List;

public class OverFactory {
    private static OverFactory overFactory;

    /**
     * Singleton
     */
    public static OverFactory getInstance() {
        if (overFactory == null) {
            overFactory = new OverFactory();
        }
        return overFactory;
    }

    /**
     * Factory
     */
    public Over getOver(final String overType,
                                      final List<RecalConsumer> recalConsumers,
                                      final List<RecalDistributor> recalDistributors,
                                      final List<RecalProducer> recalProducers) {
        return switch (overType) {
            case "consumersFirst" -> new OverConsumersFirst(recalConsumers, recalDistributors,
                    recalProducers);
            case "distributorsFirst" -> new OverDistributorsFirst(recalDistributors,
                    recalConsumers, recalProducers);
            default -> throw new IllegalArgumentException("Wrong value: " + overType);
        };
    }
}
