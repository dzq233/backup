package study;

public class Gclass<E> {
    private E name;

    public Gclass() {
    }

    public E getName() {
        return name;
    }

    public void setName(E name) {
        this.name = name;
    }

    public Gclass(E name) {
        this.name = name;
    }
}
