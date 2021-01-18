import calculate.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import parseinfo.Script;
import recalculate.Over;
import recalculate.OverFactory;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 * Entry point to the simulation
 */
public final class Main {

    private Main() { }

    /**
     * Main function which reads the input file and starts simulation
     *
     * @param args input and output files
     * @throws Exception might error when reading/writing/opening files, parsing JSON
     */
    public static void main(final String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
         Script script = objectMapper.readValue(new File(args[0]), Script.class);

        Initialize initialize = new Initialize(script);
        List<RelInfoProducer> relInfoProducers = initialize.initRelInfoProducers();
        List<RelInfoDistributor> relInfoDistributors =
                initialize.initRelInfoDistributors(relInfoProducers);
        List<RelInfoConsumer> relInfoConsumers
                =  initialize.initRelInfoConsumers(relInfoDistributors);

        OverFactory overFactory = OverFactory.getInstance();
        Over over = overFactory.getOver("consumersFirst", new LinkedList<>(),
                new LinkedList<>(), new LinkedList<>());
        Calc calc = new Calc(script, over.getDistributors(), over.getConsumers(),
                over.getEnergyProducers(), relInfoConsumers,
                relInfoDistributors, relInfoProducers);
        calc.calculate();

        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(args[1]), over);
    }
}
