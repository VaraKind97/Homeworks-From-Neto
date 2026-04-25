import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        String source = "CACABABABCCCAABAC";

        System.out.println(hasRepeats(source, 4)); // true, тк ABAB встречается два раза, хоть эти куски и пересекаются
        System.out.println(hasRepeats(source, 5)); // false
    }

    public static boolean hasRepeats(String source, int size) {
        Set<LazyString> slices = new HashSet<>();
        LazyString prev = null;

        for (int i = 0; i <= source.length() - size; i++) {
            LazyString slice;
            if (prev == null) {
                prev = new LazyString(source, 0, size);
            } else {
                slice = prev.shiftRight();
                if (slices.contains(slice)) {
                    return true;
                } else {
                    slices.add(slice);
                }
                prev = slice;
            }
        }
        return false;
    }
}