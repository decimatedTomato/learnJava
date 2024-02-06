package exercise_solutions.E04_FizzBuzz;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class FizzBuzz_03 {
    void fizzbuzz(int n, Map<Integer, String> rules) {
        for (int i = 0; i < n; i++) {
            String out = "";
            for (Entry<Integer, String> rule : rules.entrySet()) {
                if (i % rule.getKey() == 0) {
                    out += rule.getValue();
                }
            }
            if (out.equals("")) {
                out = Integer.toString(i);
            }
            System.out.println(out);
        }
    }

    public void start() {
        Map<Integer, String> rules = new HashMap<>();
        rules.put(3, "Fizz");
        rules.put(5, "Buzz");
        rules.put(7, "Bazz");
        rules.put(11, "Zip");
        rules.put(13, "Zap");
        rules.put(17, "Zop");
        fizzbuzz(100, rules);
    }
}
