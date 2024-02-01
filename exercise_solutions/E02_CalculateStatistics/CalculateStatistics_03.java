package exercise_solutions.E02_CalculateStatistics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CalculateStatistics_03 {
    public void start() {
        String fileName = "exercise_solutions/E02_CalculateStatistics/data01.txt";
        // String fileName = "exercise_solutions/E02_CalculateStatistics/data02.txt";
        // String fileName = "exercise_solutions/E02_CalculateStatistics/data03.txt";
        try {
            int[] vals = readData(fileName);
            reportStats(vals);
        } catch (FileNotFoundException e) {
            System.err.println("Nonexistent file: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    int[] readData(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        int lines = 0;
        reader.mark(1024);
        while (true) {
            if (reader.readLine() == null) break;
            lines++;
        }
        reader.reset();

        int[] vals = new int[lines];
        for (int i = 0; i < lines; i++) {
            vals[i] = Integer.parseInt(reader.readLine());
        }
        reader.close();
        return vals;
    }

    void reportStats(int[] vals) {
        int min = vals[0], max = vals[0];
        int sum = 0, var_sum = 0;
        for (int i : vals) {
            sum += i;
            if (i < min) min = i;
            if (i > max) max = i;
        }
        int range = max - min;
        float average = sum / (float)vals.length;
        
        int[] freqs = new int[range+1];
        for (int i : vals) {
            var_sum += (i-average) * (i-average);
            freqs[i-min]++;
        }
        float variance = var_sum / vals.length;
        double standard_deviation = Math.sqrt(variance);

        int q1 = vals[0];
        int median = vals[0];
        int q3 = vals[0];
        int mode_freq = 0;
        int mode = vals[0];
        int count = 0;
        for (int j = 0; j < vals.length-1; j++) {
            int v = j+min+1;
            int i = freqs[j];
            count += i;
            if (count <= (int)(vals.length/4)) {
                q1 = v;
            }
            if (count <= (int)(vals.length/2)) {
                median = v;
            }
            if (count <= (int)(3*vals.length/4)) {
                q3 = v;
            }
            if (i > mode_freq) {
                mode = v-1;
                mode_freq = i;
            }
        }
        int inter_quartile_range = q3 - q1;

        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
        System.out.println("Range: " + range);
        System.out.println("Inter-quartile Range: " + inter_quartile_range);
        System.out.println("Average: " + average);
        System.out.println("Median: " + median);
        System.out.println("Mode: " + mode);
        System.out.println("Variance: " + variance);
        System.out.println("Standard deviation: " + standard_deviation);
    }
}