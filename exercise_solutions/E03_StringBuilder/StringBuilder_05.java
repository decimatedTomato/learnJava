package exercise_solutions.E03_StringBuilder;

import java.util.LinkedList;

public class StringBuilder_05 {
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

        public int length() {
            int length = 0;
            for (String val : strings) {
                length += val.length();
            }
            return length;
        }

        public void remove(int pos) throws IndexOutOfBoundsException {
            strings.remove(pos);
        }

        @Override
        public String toString() {
            return String.join("", strings);
        }
        public String toString(String delimeter) {
            return String.join(delimeter, strings);
        }
        public String TO_CAPITALIZED_STRING() {
            return toString().replaceAll("[^A-Z]", "");
        }
    }

    public void start() {
        StringBuilder sb = new StringBuilder("Azarath");
        sb.append("Metreon");
        sb.append("ZINTHOS!");
        System.out.println(sb.toString(" "));
        System.out.println(sb.TO_CAPITALIZED_STRING());
    }
}
