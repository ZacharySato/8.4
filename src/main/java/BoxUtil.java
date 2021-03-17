public class BoxUtil {

    // скопировать содержимое из одной коробки в другую
    //Box(dest) в которую будем копировать может быть типизирована любым родителем объекта содержащимся в Box(src)
    public static <T> void copyFromBoxToBox(final Box<T> src, final Box<? super T> dest) {
        T e = src.getE();
        dest.put(e);
    }

    // скопировать содержимое из Box(src) которая может быть типизирована только классом Fruit и его наследниками,
    // при условии, что содержащийся фрукт свежий (fresh == true).
    //Box(dest) в которую будем копировать может быть типизирована любым родителем объекта содержащимся в Box(src)
    public static <T extends Fruit> void copyFreshFruitFromBoxToBox(final Box<T> src, final Box<? super T> dest) {
        T e = src.getE();
        if (e != null && e.getFresh()) {
            copyFromBoxToBox(src, dest);
        } else {
            System.out.println("В коробке " + src.toString() + " нет свежего фрукта");
            //для однозначности можно исключением
        }
    }

    //вывести в консоль (toString()) объект второй коробки
    public static void printElementFromTwoBoxes(final Box<Box<?>> box) {
        System.out.println(box.getE().toString());
    }

    //вывести в консоль (toString()) объект последней коробки
    //box Box, которая содержит в себе любое кол-во вложенных Box, в последней из которых может быть любой объект.
    public static void printElementFromBoxes(final Box<?> box) {
        if (box.getE() != null && box.getE() instanceof Box) {
            printElementFromBoxes((Box<?>) box.getE());
        } else {
            System.out.println(box.toString());
        }

    }

}