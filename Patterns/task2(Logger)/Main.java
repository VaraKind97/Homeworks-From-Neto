import java.util.*;

public class Main {
    private static int size, maxValue, treshold;

    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("Запускаем программу");
        logger.log("Просим пользователя ввести входные данные для списка");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер списка: " + scanner.hasNextInt());
        System.out.println("Введите верхнюю границу для значений: " + scanner.hasNextInt());
        logger.log("Создаём и наполняем список");
        List<Integer> list = new ArrayList<>(size);
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(maxValue));
        }
        System.out.println("Вот случайный список: " + list);
        logger.log("Просим пользователя ввести входные данные для фильтрации" );
        System.out.println("Введите порог для фильтра: " + scanner.hasNextInt());
        logger.log("Запускаем фильтрацию");
        Filter filter = new Filter(treshold);
        List<Integer> result = filter.filterOut(list);
        logger.log("Выводим результат на экран");
        System.out.println("Отфильтрованный список: " + result);
        logger.log("Завершаем программу");
    }
}