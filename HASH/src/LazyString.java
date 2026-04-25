import java.util.HashSet;
import java.util.Set;

public class LazyString {
    private String source; // ссылка на исходную строку
    private int start, end; // границы нашей подстроки
    private int hash; // запоминаем хеш чтобы не пересчитывать

    private LazyString() {
    }

    public LazyString(String source, int start, int end) {
        this.source = source;
        this.start = start;
        this.end = end;

        int hash = 0;
        for (int i = start; i < end; i++) {
            hash += source.charAt(i);
        }
        this.hash = hash;
    }

    public LazyString shiftRight() {
        // Это способ создания новой LazyString через предыдущую, работает за О(1)
        LazyString shifted = new LazyString();
        shifted.source = source;
        shifted.start = start + 1;
        shifted.end = end + 1;

        if (end <= shifted.source.length()) {
            shifted.hash = hash - shifted.source.charAt(start) + shifted.source.charAt(end);
        }
        return shifted;
    }

    public int length() {

        return end - start;
    }

    public boolean equals(LazyString that) {
        // если не равны по длине, то не равны и вовсе
        if (length() != that.length()) {
            return false;
        }

        // перебираем и сравниваем на равенство все символы
        for (int i = 0; i < length(); i++) {
            char myChar = source.charAt(start + i);
            char thatChar = source.charAt(that.start + i);
            if (myChar != thatChar) { // если хотя бы один не совпал, то не равны
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return hash; // хеш у нас всегда предпосчитан для каждого объекта, чтобы не тратить на это время
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LazyString that = (LazyString) o;
        return this.equals(that);
    }

    public static boolean hasRepeats(String source, int size) {
        Set<LazyString> slices = new HashSet<>(); // множество всех подстрок длины size
        LazyString prev = null; // переменная для сохранения предыдущей подстроки
        for (int i = 0; i <= source.length() - size; i++) { // перебор всех мест старта подстроки
            LazyString slice; // вырезание подстроки
            if (prev == null) {
                slice = new LazyString(source, i, i);
            } else {
                slice = prev.shiftRight();
                if (slice == null) {
                    break;
                }
            }
            if (slices.contains(slice)) { // проверка на наличие повтора этой подстроки
                return true; // если уже встречали, значит повторы нет
            } else {
                slices.add(slice);  // иначе запоминаем подстроку и перебираем дальше
            }
            prev = slice; // не забываем обновить переменную для предыдущей подстроки для следующей итерации цикла
        }
        return false; // если бы нашли, то вышли бы по return true, а значит повторов нет
    }

}