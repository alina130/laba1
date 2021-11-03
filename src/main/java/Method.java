import java.util.Objects;

/**
 * класс методов
 * @param <T> значение узла
 */
public class Method<T> {
    /**
     * список, узел node
     */
    private Node<T> head;
    /**
     * размер списка
     */
    private int size;

    /**
     * конструктор без параметров
     */
    public Method() {
        head = null;
        size = 0;
    }

    /**
     * добавить в конец
     * @param data значение элемента списка
     * @see Method#pushFront(Object)
     */
    public void pushBack(T data) {
        var element = head;
        var temp = new Node<>(data);
        temp.next = null;
        if (element == null) {//если пустой
            head = temp;//1й = введенному
        } else {//иначе
            while (element.next != null) {
                element = element.next;//доходим до конца
            }
            element.next = temp;//вставляем
        }
        size++;//увеличиваем размер
    }

    /**
     *добавить в начало
     * @param data значение элемента списка
     * @see Method#pushBack(Object)
     */
    public void pushFront(T data) {
        var temp = new Node<>(data);
        temp.next = head;//вставляем первым наш
        head = temp;//а прошлый первый следующим
        size++;//увеличиваем размер
    }

    /**
     * удалить 1й элемент
     * @see Method#popBack()
     */
    public void popFront() throws Exception{
        if (head == null) {//если пустой
            throw new Exception("В массиве не было элементов.");
        }
        head = head.next;//если не пустой просто говорим что наш 1й это 2й
        size--;//уменьшаем размер
    }

    /**
     * удалить последний элемент
     * @see Method#popFront()
     */
    public void popBack() throws Exception{
        if (size == 0){//если размер 0
            throw new Exception("В массиве не было элементов.");

        }
        if (size == 1) {//если он один
            head = null;//обнуляем
            size = 0;//размер 0
            throw new Exception ("Массив пуст");
        }//иначе
        var element = head;
        while (element.next.next != null) {
            element = element.next;//доходим до конца
        }
        element.next = null;//обнуляем последний
        size--;//уменьшаем размер
    }

    /**
     * удаление элемента
     * @param position место, с которого нужно удалить элемент
     */
    public void delete(int position) throws Exception{
        if (position < 0 || position > size - 1){//если за границей списка
            throw new Exception("Вышли за границу массива.");
        }
        else if (position == 0) popFront();//если пользователь ввел 1й элемент удаляем через popfront
        else if (position == size - 1) popBack();//если последний popback
        else {//иначе
            var Pos = 0;
            var element = head;
            while (position - 1 != Pos) {//пока нас счетчик не дошел до нашей позиции
                element = element.next;//переходим к след эл
                Pos++;//увеличиваем счетчик
            }
            if (element.next != null && element.next.next != null)//переопределяем
                element.next = element.next.next;
        }
    }

    /**
     * Вставка элемента
     * @param position место, на которое нужно вставить элемент
     * @param data значение элемента массива
     */
    public void insert(int position, T data) throws Exception{//вставить
        if (position < 0 || position > size){//если за границей списка
            throw new Exception("Вышли за границу массива.");

        }
        if (position == 0) pushFront(data);//если ввели первый , то через pushfront
        else if (position == size) pushBack(data);//если последний то pushBack
        else {//иначе
            var Pos = 0;
            var element = head;
            while (position - 1 != Pos) {//пока не дошли счетчиком до нужной позиции
                element = element.next;//переходим к сл эл
               Pos++;//увеличиваем счетчик
            }
            var temp = new Node<>(data);//переопределяем
            temp.next = element.next;
            element.next = temp;
        }
    }

    /**
     * получить значение элемента на какой то позиции
     * @param position позиция с которой нужно получить элемент
     * @return возвращает значение элемента
     */
    public T get(int position) throws Exception{
        if (position < 0 || position > size - 1){
            throw new Exception("Вышли за границу массива.");
        }//если вышли за рамки выводим ошибку
        var Pos = 0;
        var element = head;
        while (position != Pos) {//пока не дошли счетчиком до нужной позиции
            element = element.next;//переходим к сл эл
            Pos++;//увеличиваем счетчик
        }
        return element.data;//возвращаем значение элемента
    }

    /**
     * Печать списка
     */
    public void printList() {//печать
        if (size == 0) {//если размер=0
           return;
        }
        var element = head;
        System.out.println("Список : ");//печатаем
        while (element != null) {
            System.out.print(element.data + " ");
            element = element.next;
        }
        System.out.println();
    }

    /**
     * получить размер списка
     * @return возвращает размер списка
     */
    public int getSize() {//получить размер
        return size;
    }

    /**
     * переопределение строки
     * @return возвращает строку
     */
    @Override//показывает что мы собираемся переопределять метод базового класса
    public String toString() {
        var sb = new StringBuilder("");
        var element = head;
        while (element != null) {//пока не пустой
            sb.append(element.data).append(" ");//двигаемся по указателю и записывает элемент
            element = element.next;//переходим к следующему
        }
        return sb.toString();
    }

    /**
     * переопределяем метод базового класса equals
     * @param o
     * @return возвращает данные обьекта
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Method<?> method = (Method<?>) o;
        return size == method.size && Objects.equals(head, method.head);
    }

    /**
     * переопределяем метод базового класса hashCode
     * @return возвращает данные обьекта
     */
    @Override
    public int hashCode() {
        return Objects.hash(head, size);
    }
}