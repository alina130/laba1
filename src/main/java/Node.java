import java.util.Objects;

/**
 * Класс элементов списка
 * @param <T> название узла
 */
class Node<T> {
    T data;
    Node<T> next;

    /**
     * конструкор с параметром
     * @param key значение узла
     */
    public Node(T key) {
        data = key;//значение
        next = null;//указатель на сл эл
    }

    /**
     * переопределяем метод базового класса to String
     * @return возвращает значения узла
     */
    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }

    /**
     * переопределяем метод базового класса equals
     * @param o передаваемый параметр
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;
        return Objects.equals(data, node.data) && Objects.equals(next, node.next);
    }

    /**
     * переопределяем метод базового класса hashCode
     * @return возвращает данные обьекта
     */
    @Override
    public int hashCode() {
        return Objects.hash(data, next);
    }
}