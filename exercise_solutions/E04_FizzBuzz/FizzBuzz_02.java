package exercise_solutions.E04_FizzBuzz;

public class FizzBuzz_02 {
    void fizzbuzz(int n) {
        for (int i = 0; i < n; i++) {
            String out = "";
            if (i % 3 == 0) {
                out += "Fizz";
            }
            if (i % 5 == 0) {
                out += "Buzz";
            }
            if (out.equals("")) {
                out = Integer.toString(i);
            }
            System.out.println(out);
        }
    }

    public void start() {
        fizzbuzz(100);
    }
}
