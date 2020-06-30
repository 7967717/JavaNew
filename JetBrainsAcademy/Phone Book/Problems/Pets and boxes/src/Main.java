class Box<T extends Animal> {
    T animal;

    public void add(T t) {
        animal = t;
    }
}