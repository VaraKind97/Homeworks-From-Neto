import java.util.*;

public class Main {
    private static int size, maxValue, treshold;

    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("Запускаем программу");
        Scanner scanner = new Scanner(System.in);
        logger.log("Просим пользователя ввести входные данные для списка");
        System.out.println("Введите размер списка: ");
        if (scanner.hasNextInt()) {
            size = scanner.nextInt();
            logger.log("Введено число");
        } else {
            logger.log("Ошибка ввода!");
        }
        if (size <= 0) {
            logger.log("Введено некорректное число!");
        }
        System.out.println("Введите верхнюю границу для значений: ");
        if (scanner.hasNextInt()) {
            maxValue = scanner.nextInt();
            logger.log("Введено число.");
        } else {
            logger.log("Ошибка ввода!");
        }
        if (maxValue <= 0) {
            logger.log("Введено некорректное число!");
        }
        logger.log("Создаём и наполняем список");
        List<Integer> list = new ArrayList<>(size);
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(maxValue));
        }
        System.out.println("Вот случайный список: " + list);
        logger.log("Просим пользователя ввести входные данные для фильтрации");
        System.out.println("Введите порог для фильтра: ");
        if (scanner.hasNextInt()) {
            treshold = scanner.nextInt();
            logger.log("Введено число.");
        } else {
            logger.log("Ошибка ввода!");
        }
        if (treshold <= 0 || treshold > maxValue) {
            logger.log("Введено некорректное число!");
        }
        logger.log("Запускаем фильтрацию");
        Filter filter = new Filter(treshold);
        List<Integer> result = filter.filterOut(list);
        logger.log("Выводим результат на экран");
        System.out.println("Отфильтрованный список: " + result);
        logger.log("Завершаем программу");
    }
}
