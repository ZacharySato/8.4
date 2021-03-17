public class Box<T> {
    private T e;

    public final T getE() {
        return e;
    }

    public final void put(final T object) {
        e = object;
    }

}