package exercise_solutions.E02_CalculateStatistics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class CalculateStatistics_04 {
    public void start() {
        // String fileName = "exercise_solutions/E02_CalculateStatistics/data01.txt";
        // String fileName = "exercise_solutions/E02_CalculateStatistics/data02.txt";
        String fileName = "exercise_solutions/E02_CalculateStatistics/data03.txt";
        try {
            List<Double> vals = readData(fileName);
            reportStats(vals);
        } catch (FileNotFoundException e) {
            System.err.println("Nonexistent file: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Double> readData(String fileName) throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        Iterator<String> lines = reader.lines().iterator();
        List<Double> data = new ArrayList<>();
        while (lines.hasNext()) {
            try {
                data.add(Double.parseDouble(lines.next()));
            } catch (Exception e) {}
        }
        reader.close();
        return data;
    }

    private double calculate_range(List<Double> vals) {
        return vals.get(vals.size()-1) - vals.get(0);
    }

    private double calculate_variance(List<Double> vals) {
        double sum = 0;
        double mean = calculate_average(vals);
        for (Double val : vals) {
            double x = val - mean;
            sum += x*x;
        }
        return sum / vals.size();
    }

    private double calculate_average(List<Double> vals) {
        double sum = 0;
        for (Double val : vals) {
            sum += val;
        }
        return sum / vals.size();
    }

    private List<Double> calculate_mode(List<Double> vals) {
        int max_frequency = 0;
        Map<Double, Integer> frequencies = new HashMap<>();
        for (Double val : vals) {
            int occurances = frequencies.getOrDefault(val, 0) + 1;
            frequencies.put(val, occurances);
            if (occurances > max_frequency) {
                max_frequency = occurances;
            }
        }
        List<Double> mode = new ArrayList<>();
        for (Entry<Double, Integer> frequency : frequencies.entrySet()) {
            if (frequency.getValue() == max_frequency) {
                mode.add(frequency.getKey());
            }
        }
        return mode;
    }

    private double find_value_at(List<Double> vals, int num, int denom) {
        int len = vals.size();
        return (vals.get((num*len)/denom) + vals.get((num*(len+1))/denom)) / 2;
    }

    private double calculate_median(List<Double> vals) {
        return find_value_at(vals, 1, 2);
    }
    
    private double calculate_iqr(List<Double> vals) {
        return find_value_at(vals, 3, 4) - find_value_at(vals, 1, 4);
    }

    private void reportStats(List<Double> vals) {
        if (vals.size() == 0) {
            System.err.println("Unable to process data due to: data length is 0");
            return;
        }
        List<Double> sorted_vals = new ArrayList<>(vals);
        Collections.sort(sorted_vals);
        
        System.out.println("Max: " + sorted_vals.get(0));
        System.out.println("Min: " + sorted_vals.get(sorted_vals.size()-1));
        System.out.println("Range: " + calculate_range(sorted_vals));
        System.out.println("Inter-quartile Range: " + calculate_iqr(sorted_vals));
        System.out.println("Average: " + calculate_average(vals));
        System.out.println("Median: " + calculate_median(sorted_vals));
        System.out.println("Mode: " + calculate_mode(sorted_vals));
        System.out.println("Variance: " + calculate_variance(vals));
        System.out.println("Standard deviation: " + Math.sqrt(calculate_variance(vals)));
    }
}