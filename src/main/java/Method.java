public class Method<T> {//класс методов

    private Node<T> head;
    private int size;

    public Method() {
        head = null;
        size = 0;
    }

    public void pushBack(T data) {//добавить в конец
        var h = head;
        var temp = new Node<>(data);
        temp.next = null;
        if (h == null) {//если пустой
            head = temp;//1й = введенному
        } else {//иначе
            while (h.next != null) {
                h = h.next;//доходим до конца
            }
            h.next = temp;//вставляем
        }
        size++;//увеличиваем размер
    }

    public void pushFront(T data) {//добавить в начало
        var temp = new Node<>(data);
        temp.next = head;//вставляем первым наш
        head = temp;//а прошлый первый следующим
        size++;//увеличиваем размер
    }

    public void popFront() {//удалить 1й
        if (head == null) {
            System.out.println("В массиве не было элементов.");
            return;
        }//если первого нет выходим
        head = head.next;//если не пустой просто говорим что наш 1й это 2й
        size--;//уменьшаем размер
    }

    public void popBack() {//удалить последний
        if (size == 0){//если размер 0
            System.out.println("В массиве не было элементов.");
            return;
        }
        if (size == 1) {//если он один
            head = null;//обнуляем
            size = 0;//размер 0
            System.out.println("Массив пуст");
            return;//выходим
        }//иначе
        var h = head;
        while (h.next.next != null) {
            h = h.next;//доходим до конца
        }
        h.next = null;//обнуляем последний
        size--;//уменьшаем размер
    }

    public void delete(int position) {//удалить
        if (position < 0 || position > size - 1){//если за границей массива
            System.out.println("Вышли за границу массива.");
            return;
        }
        else if (position == 0) popFront();//если пользователь ввел 1й элемент удаляем через popfront
        else if (position == size - 1) popBack();//ессли последний popback
        else {//иначе
            var Pos = 0;
            var h = head;
            while (position - 1 != Pos) {//пока нас счетчик не дошел до нашей позиции
                h = h.next;//переходим к след эл
                Pos++;//увеличиваем счетчик
            }
            if (h.next != null && h.next.next != null)//переопределяем ссылки
                h.next = h.next.next;
        }
    }

    public void insert(int position, T data) {//вставить
        if (position < 0 || position > size){//если за границей массива
            System.out.println("Вышли за границу массива.");
            return;
        }
        if (position == 0) pushFront(data);//если ввели первый , то через pushfront
        else if (position == size) pushBack(data);//если последний то pushBack
        else {//иначе
            var Pos = 0;
            var h = head;
            while (position - 1 != Pos) {//пока не дошли счетчиком до нужной позиции
                h = h.next;//переходим к сл эл
               Pos++;//увеличиваем счетчик
            }
            var temp = new Node<>(data);//переопределяем
            temp.next = h.next;
            h.next = temp;
        }
    }

    public T get(int position) {//получить элемент
        if (position < 0 || position > size - 1) throw new IndexOutOfBoundsException();//если вышли за рамки выводим ошибку
        var Pos = 0;
        var h = head;
        while (position != Pos) {//пока не дошли счетчиком до нужной позиции
            h = h.next;//переходим к сл эл
            Pos++;//увеличиваем счетчик
        }
        return h.data;//возвращаем значение элемента
    }

    public void printList() {//печать
        if (size == 0) {//если размер=0
            System.out.println("Список пуст.");
            return;
        }
        var h = head;
        System.out.println("Список : ");//печатаем
        while (h != null) {
            System.out.print(h.data + " ");
            h = h.next;
        }
        System.out.println();
    }

    public int getSize() {//получить размер
        return size;
    }

    @Override//показывает что мы собираемся переопределять метод базового класса
    public String toString() {
        var sb = new StringBuilder("");
        var h = head;
        while (h != null) {//пока не пустой
            sb.append(h.data).append(" ");//двигаемся по указателю и записывает элемент
            h = h.next;//переходим к следующему
        }
        return sb.toString();
    }
}