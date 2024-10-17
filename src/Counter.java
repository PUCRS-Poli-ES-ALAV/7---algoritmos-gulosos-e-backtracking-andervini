/**
 * @author Anderson R. P. Sprenger
 * @author Vinicius P. Dias
 */

public class Counter {
    private int count;
    private long startTime;
    private long endTime;

    public Counter() {
        this.count = 0;
        this.startTime = 0;
        this.endTime = 0;
    }

    public void startCount() {
        count = 0;
        startTime = System.nanoTime();
        endTime = 0;
    }

    public void addCount(int n) {
        count += n;
    }

    public void endCount() {
        endTime = System.nanoTime();
    }

    public int getCount() {
        return count;
    }

    public long getDuration() {
        if (startTime == 0 || endTime == 0) {
            throw new IllegalStateException("Counter has not been finished yet");
        }

        return endTime - startTime;
    }

    @Override
    public String toString() {
        return "Counter{" +
                "count=" + getCount() +
                ", duration=" + getDuration() +
                '}';
    }
}