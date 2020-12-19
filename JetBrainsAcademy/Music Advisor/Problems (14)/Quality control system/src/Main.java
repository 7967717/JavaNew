import java.util.List;

class QualityControl {

    public static boolean check(List<?> boxes) {
            if (boxes == null) {
                return false;
            } else
            if (boxes.isEmpty()) {
                return true;
            } else {
                for (Object obj: boxes) {
                    if (!(obj instanceof Box)) {
                        return false;
                    }
                    else {
                        Box box = (Box) obj;
                        return box.get() != null && box.get() instanceof Cake &&
                                box.get() instanceof Pie && box.get() instanceof Tart
                                && box.get() instanceof Bakery;
                    }
                }
            }
            return true;
    }

}

// Don't change the code below
class Bakery {
}

class Cake extends Bakery {
}

class Pie extends Bakery {
}

class Tart extends Bakery {
}

class Paper {
}

class Box<T> {

    private T item;

    public void put(T item) {
        this.item = item;
    }

    public T get() {
        return this.item;
    }
}