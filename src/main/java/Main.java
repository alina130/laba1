import java.util.Scanner;

public class Main //главный мейн
{
    public static void main(String[] args) //публичный метод main с массивом аргументов
    {
        var list = new Method<Integer>(); //создаем список
        var choice = 1; //переменная для выбора действия
        do { //делаем
            var in = new Scanner(System.in);
            System.out.println("- Введите команду:");
            System.out.println("1-Добавить в конец");
            System.out.println("2-Добавить в начало");
            System.out.println("3-Удалить с конца");
            System.out.println("4-Удалить с начала");
            System.out.println("5-Вставить куда либо");
            System.out.println("6-Удалить");
            System.out.println("7-Получить значение");
            System.out.println("8-Печать");
            System.out.println("0-Выход");

            choice = in.nextInt();//выбор команды

            switch (choice) {

                case 1://добавить в конец
                {
                    System.out.println("Введите значение : ");
                    var i = in.nextInt();//в i сохраняем номер действия
                    list.pushBack(i);//добавляем
                    list.printList();//печатаем
                    break;
                }
                case 2: //добавить в начало
                {
                    System.out.println("Введите значение : ");
                    var i = in.nextInt();
                    list.pushFront(i);//добавляем
                    list.printList();//печатаем
                    break;
                }
                case 3://удалить с конца
                {
                    list.popBack();//удаляем
                    list.printList();//печатаем
                    break;
                }
                case 4: //удалить с начала
                {
                    list.popFront();//удаляем
                    list.printList();//печатаем
                    break;
                }
                case 5: //добавить после
                {
                    System.out.println("На какую позицию вставить элемент : ");
                    var position = in.nextInt()-1;//запоминаем позицию
                    System.out.println("Введите значение : ");
                    var value = in.nextInt();//запоминаем элемент
                    list.insert(position, value);//вставляем
                    list.printList();//печатаем
                    break;
                }
                case 6: //удаление внутри
                {
                    System.out.println("Какой по счету элемент удалить : ");
                    var position = in.nextInt()-1;//сохраняем позицию
                    list.delete(position);//удаляем элемент на этой позиции
                    list.printList();//печатаем
                    break;
                }
                case 7://получение элемента
                {
                    System.out.println("Значение какого элемента вы хотите получить : ");
                    var position = in.nextInt()-1;//запоминаем позицию
                    System.out.println(list.get(position));//печатаем элемент на этой позиции
                    list.printList();//печатаем
                    break;
                }
                case 8: //печать
                {
                    list.printList();//печатаем
                    break;
                }
            }
        } while (choice != 0);// выполняем пока не ноль
    }
}

