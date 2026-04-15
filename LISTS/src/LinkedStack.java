
public class LinkedStack {
    private Node tail; // ссылка на последний добавленный узел (обёртку)
    private int size; // размер стека, т.е. количество элементов в нём

    public void push(int value) {
        Node node = new Node(value); // создаём новый узел
        if (tail != null) { // если в стеке уже есть элементы
            node.setPrev(tail); // связываем новый узел с последним
        }
        tail = node; // назначаем новый узел последним узлом
        size++; // увеличиваем счётчик элементов
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Empty");
        }
        int value = tail.getValue();
        tail = tail.getPrev();
        return value;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return tail == null; // проверяем, пуст ли стек (нет последнего узла)
    }

    public String toString() {
        if (isEmpty()) {
            return "EMPTY"; // если стек пуст, возвращаем "EMPTY"
        }

        StringBuilder result = new StringBuilder();
        Node current = tail;

        while (current != null) {
            result.append(current.getValue());

            if (current.getPrev() != null) {
                result.append(" -> ");
            }

            current = current.getPrev();
        }

        return result.toString();
    }
}