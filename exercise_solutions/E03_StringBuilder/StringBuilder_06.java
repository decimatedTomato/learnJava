package exercise_solutions.E03_StringBuilder;

public class StringBuilder_06 {
    private class myStringBuilder extends AbstractStringBuilder {
        StringBuilder _sb;

        myStringBuilder(String initial) {
            _sb = new StringBuilder(initial);
        }

        public AbstractStringBuilder append(String val) {
            _sb.append(val);
            return this;
        }

        @Override
        public String toString() {
            return _sb.toString();
        }
    } 
    
    public void start() {
        StringBuilder sb = new StringBuilder("Azarath ");
        sb.append("Metreon ");
        sb.append("ZINTHOS!");
        System.out.println(sb.toString());
    }
}
