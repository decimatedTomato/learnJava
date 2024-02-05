package exercise_solutions.E03_StringBuilder;

import java.util.LinkedList;

public class StringBuilder_01 {
    class StringBuilder {
        LinkedList<String> strings;

        StringBuilder() {
            strings = new LinkedList<>();
        }

        void append(String string) {
            strings.add(string);
        }

        @Override
        public String toString() {
            return String.join("", strings);
        }
    }


    public void start() {
        StringBuilder sb = new StringBuilder();
        System.out.println(sb);
        sb.append("a");
        System.out.println(sb);
        sb.append("b");
        System.out.println(sb);
        sb.append("c");
        System.out.println(sb);
    }
}
