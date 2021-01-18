package recalculate;

import java.util.List;

public class OverConsumersFirst extends Over {

    public OverConsumersFirst(final List<RecalConsumer> consumers,
                              final List<RecalDistributor> distributors,
                              final List<RecalProducer> producers) {
        super(consumers, distributors, producers);
    }
}
