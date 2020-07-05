package io.rr.generics;

import java.util.ArrayList;
import java.util.List;

public class Wildcards {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        List<Album> albums = new ArrayList<>();
        List<List<? extends Book>> lists = new ArrayList<>();
        lists.add(books);
        lists.add(albums);

        List<? extends Book> list = new ArrayList<>();
//        list.add(new Book());
//        list.add(new Album());
        list.add(null);

    }
}

class Book{}
class Album extends Book {}
class Booklet extends Book {}
class AudioFile {}

