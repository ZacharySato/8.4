public class Main {
    public static void main(final String[] args) {
        Apple apple = new Apple();
        Fruit fruit = new Fruit();

        Box<Apple> appleBox = new Box<>();
        apple.setFresh(false);
        appleBox.put(apple);

        Box<Fruit> fruitBox = new Box<>();
        fruitBox.put(fruit);
        fruit.setFresh(true);

        Box<Box<?>> nested = new Box<>();
        nested.put(appleBox);

        System.out.println("\n" + "Вторая коробка " + appleBox.toString() + ", проверяем");
        BoxUtil.printElementFromTwoBoxes(nested);
        System.out.print("\n");

        BoxUtil.copyFromBoxToBox(appleBox, fruitBox);
        Box<Object> objBox = new Box<>();
        objBox.put(new Object());
        Box<String> stringBox = new Box<>();
        stringBox.put("Inbox");
        BoxUtil.copyFromBoxToBox(stringBox, objBox);

        BoxUtil.copyFreshFruitFromBoxToBox(appleBox, fruitBox);
        apple.setFresh(true);
        BoxUtil.copyFreshFruitFromBoxToBox(appleBox, fruitBox);

        Box<Box<Fruit>> box = new Box<>();
        Box<Box<?>> boxBox = new Box<>();
        Box<Box<?>> boxBoxBox = new Box<>();
        boxBox.put(box);
        boxBoxBox.put(boxBox);
        box.put(fruitBox);
        System.out.println("\n" + fruitBox + " последний в матрешке, проверяем");
        BoxUtil.printElementFromBoxes(boxBoxBox);
    }
}