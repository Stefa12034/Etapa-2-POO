package recalculate;

import java.util.List;

public class OverDistributorsFirst extends Over {

    public OverDistributorsFirst(final List<RecalDistributor> distributors,
                                 final List<RecalConsumer> consumers,
                                 final List<RecalProducer> producers) {
        super(consumers, distributors, producers);
    }
}
