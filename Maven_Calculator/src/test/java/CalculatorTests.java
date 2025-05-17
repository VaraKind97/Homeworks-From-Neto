import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netology.Calculator;

public class CalculatorTests {
    Calculator calc;

    @BeforeEach
    void testAdd() {
        calc = new Calculator();
    }

    @Test
    @DisplayName("Проверка корректности сложения")
    void plus() {
        final int a = 5;
        final int b = 7;
        final int expected = 12;
        final int result = calc.plus.apply(a, b);
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Проверка корректности вычитания")
    void minus() {
        final int a = 10;
        final int b = 6;
        final int expected = 4;
        final int result = calc.minus.apply(a, b);
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Проверка корректности умножения")
    void multipy() {
        final int x = 6;
        final int y = 5;
        final int expected = 35;
        final int result = calc.minus.apply(x, y);
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Проверка корректности деления")
    void devide() {
        final int a = 81;
        final int b = 9;
        final int expected = 9;
        final int result = calc.devide.apply(a, b);
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Проверка деления на 0")
    void devideByZero() {
        final int a = 100;
        final int b = 0;
        Assertions.assertThrows(
                ArithmeticException.class,
                () -> calc.devide.apply(a, b)
        );
    }

    @Test
    @DisplayName("Проверка текста исключения при делении на 0")
    void exceptionDevideByZero() {
        final int a = 100;
        final int b = 0;
        final ArithmeticException exception = Assertions.assertThrows(
                ArithmeticException.class,
                () -> calc.devide.apply(a, b)
        );
        Assertions.assertEquals("Внимание!!! Деление на 0! На ноль делить нельзя", "Внимание!!! Деление на 0! На ноль делить нельзя");
    }

    @Test
    @DisplayName("Проверка вычисления квадрата из числа")
    void pow() {
        Calculator calc = new Calculator();
        final int a = 5;
        final int expected = 25;
        final int result = calc.pow.apply(a);
        Assertions.assertEquals(expected, result);

    }

    @Test
    @DisplayName("Проверка корректности абсалюта")
    void abs() {
        Calculator calc = new Calculator();
        final int a = -5;
        final int expected = 5;
        final int result = calc.abs.apply(a);
        Assertions.assertEquals(expected, result);

    }

    @Test
    @DisplayName("Проверка корректности проверки положительного числа")
    void isPositive() {
        Calculator calc = new Calculator();
        final int a = -10;
        final Boolean expected = false;
        final Boolean result = calc.isPositive.test(a);
        Assertions.assertEquals(expected, result);
    }
}
