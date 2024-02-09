package exercise_solutions.E03_StringBuilder;

public class StringBuilder_06 {
    private class myStringBuilder {
        StringBuilder _sb;

        myStringBuilder(String initial) {
            _sb = new StringBuilder(initial);
        }

        public myStringBuilder append(String val) {
            _sb.append(val);
            return this;
        }

        @Override
        public String toString() {
            return _sb.toString();
        }
    } 
    
    public void start() {
        myStringBuilder sb = new myStringBuilder("Azarath ");
        sb.append("Metreon ");
        sb.append("ZINTHOS!");
        System.out.println(sb.toString());
    }
}
