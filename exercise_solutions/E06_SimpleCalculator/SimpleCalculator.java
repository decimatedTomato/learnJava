package exercise_solutions.E06_SimpleCalculator;


public class SimpleCalculator {
    public static void main(String[] args) {
        System.out.println("Length:" + args.length);
        for (String arg : args) {
            System.out.println(arg);
        }
    }
}