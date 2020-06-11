package io.rr.algorithms;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

/*
SQL for
create table person(ID INT PRIMARY KEY NOT NULL, NAME TEXT NOT NULL);
insert into person (id, name) values (1, 'a'), (2, 'b'), (3, 'c'), (4, 'b'), (5, 'c'), (6, 'c');
select * from person;
select distinct b.id, b.name from person a inner join person b on a.name = b.name where a.id < b.id;
delete from person a using person b where a.name = b.name and a.id > b.id;
 */

public class GetDuplicatesList {
    public static void main(String[] args) {
        GetDuplicatesList inst = new GetDuplicatesList();
        System.out.println(inst.getDuplicates(inst.fillList()));
        System.out.println(inst.getDuplicates1(inst.fillList()));
        System.out.println(inst.getDuplicates2(inst.fillList()));
    }

    private List<Elem> getDuplicates(ArrayList<Elem> list) {
        ArrayList<Elem> elems = new ArrayList<>(list);
        Set<String> set = list.stream().map(elem -> elem.name).collect(Collectors.toSet());
        for (String s : set) {
            for (Elem elem : list) {
                if (elem.name.equals(s)) {
                    elems.remove(elem);
                    break;
                }
            }
        }
        return elems;
    }

    private List<Elem> getDuplicates1(ArrayList<Elem> list) {
        HashSet<String> set = new HashSet<>();
        List<Elem> duplicates = new ArrayList<>();
        for (Elem elem : list) {
            if (!set.add(elem.name)) {
                duplicates.add(elem);
            }
        }
        return duplicates;
    }

    private List<Elem> getDuplicates2(ArrayList<Elem> list) {
        Map<String, List<Elem>> map = getDuplicatesMap(list);
        return map.values().stream()
                .filter(duplicates -> duplicates.size() > 1)
                .map(elems -> elems.subList(1, elems.size()))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    private static Map<String, List<Elem>> getDuplicatesMap(List<Elem> list) {
        return list.stream().collect(Collectors.groupingBy(elem -> elem.name));
    }

    private ArrayList<Elem> fillList() {
        ArrayList<Elem> list = new ArrayList<>();
        list.add(new Elem(1, "a"));
        list.add(new Elem(2, "b"));
        list.add(new Elem(3, "c"));
        list.add(new Elem(4, "b"));
        list.add(new Elem(5, "c"));
        list.add(new Elem(6, "c"));
        return list;
    }

    @Data
    @AllArgsConstructor
    static class Elem {
        int id;
        String name;
    }
}
