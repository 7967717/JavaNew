class Book {

    private String title;
    private int yearOfPublishing;
    private String[] authors;

    public Book(String title, int yearOfPublishing, String[] authors) {
        this.title = title;
        this.yearOfPublishing = yearOfPublishing;
        this.authors = authors.clone();
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < authors.length; i++) {
            if (i == authors.length - 1) {
                sb.append(authors[i]).append("]");
            } else {
                sb.append(authors[i]).append(",");
            }
        }
        return "title=" + title +
                ",yearOfPublishing=" + yearOfPublishing +
                ",authors=" + sb.toString();
    }
}