package exercise_solutions.E03_StringBuilder;

import java.util.LinkedList;

public class StringBuilder_04 {
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
            return String.join(null, strings);
        }
        public String toString(String delimeter) {
            return String.join(delimeter, strings);
        }
    }

    public void start() {
        StringBuilder sb = new StringBuilder("Azarath");
        sb.append("Metreon");
        sb.append("Zinthos");
        System.out.println(sb.toString(" "));
    }
}
