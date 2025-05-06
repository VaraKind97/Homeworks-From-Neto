import java.util.Iterator;
import java.util.Random;

public class Randoms implements Iterable<Integer> {
    protected int min, max;

    public Randoms(int min, int max) {
        Random random = new Random();
        this.min = min;
        this.max = max;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public Integer next() {
                return new Random().nextInt(min, (max + 1));
            }
        };
    }
}