package exercise_solutions.E03_StringBuilder;

import java.util.LinkedList;

public class StringBuilder_02 {
    class StringBuilder {
        LinkedList<String> strings;

        StringBuilder() {
            strings = new LinkedList<>();
        }
        StringBuilder(String initial) {
            strings = new LinkedList<>();
            strings.add(initial);
        }
        StringBuilder(String[] vals) {
            strings = new LinkedList<String>();
            for (String val : vals) {
                strings.add(val);
            }
        }
        StringBuilder(int val) {
            strings = new LinkedList<>();
            strings.add(Integer.toString(val));
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
        StringBuilder sb = new StringBuilder("abc");
        System.out.println(sb);
        sb.append("d");
        System.out.println(sb);
    }
}
