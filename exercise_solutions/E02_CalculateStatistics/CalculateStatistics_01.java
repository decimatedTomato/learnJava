package exercise_solutions.E02_CalculateStatistics;


public class CalculateStatistics_01 {
    public void start() {
        int[] vals = {0, -1, 2, 11, -5, 3, 4, 1, 1, -2, 3, 14, 3, 3, 8, 6, 2, 0, 1, 1};
        int min = vals[0];
        for (int i : vals) {
            if (i < min) min = i;
        }
        System.out.println("Min: " + min);
    }
}