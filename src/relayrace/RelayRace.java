
package relayrace;

import static relayrace.Tools.sleep;


public class RelayRace {
public static void main(String[] args) {
        int n = 10;
        if (args.length > 0) {
            n = Integer.parseInt(args[0]);
        }

        Race race = new Race(n);

        for (int i = 0; i < n; ++i) {
            Runner r = new Runner(i, n);
            race.addRunner(r);
        }

        race.go();
        sleep(10000);
        race.stop();
    }

}

   