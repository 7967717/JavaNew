class Shelf<T extends Book> {
    T t;

    void setElement(T t) {
        this.t = t;
    }

    T getElement() {
        return t;
    }

}