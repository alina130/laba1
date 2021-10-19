import java.util.Objects;

class Node<T> { //класс элементов массива
    T data;
    Node<T> next;

    public Node(T key) {
        data = key;//значение
        next = null;//указатель на сл эл
    }

    @Override//показывает что мы собираемся переопределять метод базового класса
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;
        return Objects.equals(data, node.data) && Objects.equals(next, node.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, next);
    }
}