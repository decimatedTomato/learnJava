package exercise_solutions.E02_CalculateStatistics;

public class CalculateStatistics_02 {
    public void start() {
        int[] vals = {0, -1, 2, 11, -5, 3, 4, 1, 1, -2, 3, 14, 3, 3, 8, 6, 2, 0, 1, 1};
        reportStats(vals);
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
        System.out.println("Standard deviation: " + standard_deviation);
    }
}